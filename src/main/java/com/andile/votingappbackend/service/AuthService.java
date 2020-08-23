package com.andile.votingappbackend.service;

import com.andile.votingappbackend.config.JWTProvider;
import com.andile.votingappbackend.dto.AuthResponse;
import com.andile.votingappbackend.dto.LoginRequest;
import com.andile.votingappbackend.dto.RegisterRequest;
import com.andile.votingappbackend.exception.ActivationException;
import com.andile.votingappbackend.model.AccountVerificationToken;
import com.andile.votingappbackend.model.NotificationEmail;
import com.andile.votingappbackend.model.User;
import com.andile.votingappbackend.repository.TokenRepository;
import com.andile.votingappbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static com.andile.votingappbackend.config.Constants.EMAIL_ACTIVATION;

@Service
@AllArgsConstructor
public class AuthService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    TokenRepository tokenRepository;
    MailService mailService;
    MailBuilder mailBuilder;
    AuthenticationManager authenticationManager;
    JWTProvider jwtProvider;

    @Transactional
    public void register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setCreationDate(Instant.now());
        user.setAccountStatus(false);

        userRepository.save(user);

        String token = generateToken(user);
        String message = mailBuilder.build("Welcome to React-Spring-Reddit Clone. " +
                "Please visit the link below to activate you account : " + EMAIL_ACTIVATION + "/" + token);
        mailService.sendEmail(new NotificationEmail("Please Activate Your Account", user.getEmail(), message));
    }

    public AuthResponse login (LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest. getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authToken = jwtProvider.generateToken(authenticate);
        return new AuthResponse(authToken, loginRequest.getUsername());
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private String generateToken(User user) {
        String token = UUID.randomUUID().toString();
        AccountVerificationToken verificationToken = new AccountVerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        tokenRepository.save(verificationToken);
        return token;
    }

    public void verifyToken(String token) {
        Optional<AccountVerificationToken> verificationToken = tokenRepository.findByToken(token);
        verificationToken.orElseThrow(() -> new ActivationException("Invalid Activation Token"));
        enableAccount(verificationToken.get());
    }

    public void enableAccount(AccountVerificationToken token) {
        String username = token.getUser().getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ActivationException("User not found with username: " + username));
        user.setAccountStatus(true);
        userRepository.save(user);
    }
}
