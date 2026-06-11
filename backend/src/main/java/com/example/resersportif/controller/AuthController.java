package com.example.resersportif.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.resersportif.dto.AuthResponse;
import com.example.resersportif.dto.LoginRequest;
import com.example.resersportif.dto.RegisterRequest;
import com.example.resersportif.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    private final ClientService clientService;

    public AuthController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @Valid @RequestBody RegisterRequest request) {

        clientService.register(request);

        return ResponseEntity.ok("Compte créé avec succès.");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                clientService.login(request));
    }
}