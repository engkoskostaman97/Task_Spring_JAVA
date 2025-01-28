package com.belajar.jwt.belajar.jwt.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private Long userid;
    private String email;
    private String token;

    public AuthResponse(Long userid, String email, String token) {
        this.userid = userid;
        this.email = email;
        this.token = token;
    }
}

