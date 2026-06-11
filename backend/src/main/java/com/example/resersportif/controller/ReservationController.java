package com.example.resersportif.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.resersportif.dto.ReservationRequest;
import com.example.resersportif.entity.Reservation;
import com.example.resersportif.service.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(
            @Valid @RequestBody ReservationRequest request) {

        return ResponseEntity.ok(
                reservationService.createReservation(request));
    }
}