package com.andile.votingappbackend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}
/*
* RegisterRequest: Defines the data that our backend will recieve
* from the client during a registration request.
*  */