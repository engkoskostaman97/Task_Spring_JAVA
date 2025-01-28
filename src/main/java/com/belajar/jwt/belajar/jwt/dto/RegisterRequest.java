package com.belajar.jwt.belajar.jwt.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String namadepan;
    private String namabelakang;
    private String nomortelephone;
    private String email;
    private String password;
    private String konfirmasipassword;
}

