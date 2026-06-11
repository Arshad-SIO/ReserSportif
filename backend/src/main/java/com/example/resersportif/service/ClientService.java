package com.example.resersportif.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.resersportif.dto.AuthResponse;
import com.example.resersportif.dto.LoginRequest;
import com.example.resersportif.dto.RegisterRequest;
import com.example.resersportif.entity.Client;
import com.example.resersportif.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public ClientService(ClientRepository clientRepository,
                         PasswordEncoder passwordEncoder,
                         JwtService jwtService) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void register(RegisterRequest request) {

        if (clientRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Cet email existe déjà.");
        }

        Client client = Client.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        clientRepository.save(client);
    }

    public AuthResponse login(LoginRequest request) {

        Client client = clientRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable."));

        if (!passwordEncoder.matches(
                request.getPassword(),
                client.getPassword())) {

            throw new RuntimeException("Mot de passe incorrect.");
        }

        String token = jwtService.generateToken(client.getEmail());

        return new AuthResponse(token);
    }
}