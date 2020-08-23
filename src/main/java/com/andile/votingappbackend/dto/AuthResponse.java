package com.andile.votingappbackend.dto;

import lombok.*;

@Data
@AllArgsConstructor

public class AuthResponse {
    private String authenticationToken;
    private String username;
}
