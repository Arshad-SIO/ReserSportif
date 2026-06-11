package com.example.resersportif.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(nullable = false)
    private String date;

    @Enumerated(EnumType.STRING)
    private TypeReservation type;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idTerrain")
    private TerrainSportif terrainSportif;
}