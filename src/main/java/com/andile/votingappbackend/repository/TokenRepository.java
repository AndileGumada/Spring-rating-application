package com.andile.votingappbackend.repository;

import com.andile.votingappbackend.model.AccountVerificationToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TokenRepository extends CrudRepository<AccountVerificationToken, Long> {
    Optional<AccountVerificationToken> findByToken(String token);
}
