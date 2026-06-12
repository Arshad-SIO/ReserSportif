package com.example.resersportif.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.resersportif.dto.RegisterRequest;
import com.example.resersportif.entity.Client;
import com.example.resersportif.repository.ClientRepository;

public class ClientServiceTest {

    @Test
    void register_shouldSaveClientWithEncodedPassword() {
        ClientRepository clientRepository = Mockito.mock(ClientRepository.class);
        PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
        JwtService jwtService = Mockito.mock(JwtService.class);

        ClientService clientService =
                new ClientService(clientRepository, passwordEncoder, jwtService);

        RegisterRequest request = new RegisterRequest();
        request.setNom("Umair");
        request.setPrenom("Arshad");
        request.setEmail("umair@gmail.com");
        request.setPassword("123456");

        when(clientRepository.existsByEmail("umair@gmail.com")).thenReturn(false);
        when(passwordEncoder.encode("123456")).thenReturn("password_hash");

        clientService.register(request);

        verify(clientRepository).save(Mockito.any(Client.class));
        verify(passwordEncoder).encode("123456");
    }
}