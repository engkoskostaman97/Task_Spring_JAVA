package com.belajar.jwt.belajar.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.belajar.jwt.belajar.jwt.dto.AuthRequest;
import com.belajar.jwt.belajar.jwt.dto.RegisterRequest;
import com.belajar.jwt.belajar.jwt.dto.RegisterResponse;
import com.belajar.jwt.belajar.jwt.dto.AuthResponse;
import com.belajar.jwt.belajar.jwt.service.AuthService;

@RestController
@RequestMapping("/api/auth")
// @CrossOrigin(origins = "http://127.0.0.1:5173")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}

