package com.example.resersportif.dto;

import com.example.resersportif.entity.TypeReservation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservationRequest {

    @NotNull
    private Long idClient;

    @NotNull
    private Long idTerrain;

    @NotBlank
    private String date;

    @NotNull
    private TypeReservation type;
}