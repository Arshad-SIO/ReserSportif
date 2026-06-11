package com.example.resersportif.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.resersportif.dto.ReservationRequest;
import com.example.resersportif.entity.Client;
import com.example.resersportif.entity.Reservation;
import com.example.resersportif.entity.TerrainSportif;
import com.example.resersportif.repository.ClientRepository;
import com.example.resersportif.repository.ReservationRepository;
import com.example.resersportif.repository.TerrainSportifRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final TerrainSportifRepository terrainRepository;

    public ReservationService(
            ReservationRepository reservationRepository,
            ClientRepository clientRepository,
            TerrainSportifRepository terrainRepository) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.terrainRepository = terrainRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation createReservation(ReservationRequest request) {

        Client client = clientRepository.findById(request.getIdClient())
                .orElseThrow(() -> new RuntimeException("Client introuvable."));

        TerrainSportif terrain = terrainRepository.findById(request.getIdTerrain())
                .orElseThrow(() -> new RuntimeException("Terrain introuvable."));

        Reservation reservation = Reservation.builder()
                .date(request.getDate())
                .type(request.getType())
                .client(client)
                .terrainSportif(terrain)
                .build();

        return reservationRepository.save(reservation);
    }
}