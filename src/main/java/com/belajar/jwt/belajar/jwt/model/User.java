package com.belajar.jwt.belajar.jwt.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) 
    private String email;

    @Column(name = "nama depan") 
    private String namadepan;

    @Column(name = "nama belakang") 
    private String namabelakang;

    @Column(name = "nomor telephone") 
    private String telephone;

    private String password;

    @Column(name = "konfirmasi password") 
    private String konfirmasipassword;
}
