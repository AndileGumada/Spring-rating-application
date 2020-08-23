package com.andile.votingappbackend.controller;

import com.andile.votingappbackend.dto.AuthResponse;
import com.andile.votingappbackend.dto.LoginRequest;
import com.andile.votingappbackend.dto.RegisterRequest;
import com.andile.votingappbackend.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest registerRequest) {
        authService.register(registerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/verify/{token}")
    public ResponseEntity verify(@PathVariable String token) {
        authService.verifyToken(token);
        return new ResponseEntity<>("Account Activated", HttpStatus.OK);
    }
    @PostMapping("/login")
    public AuthResponse register(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
