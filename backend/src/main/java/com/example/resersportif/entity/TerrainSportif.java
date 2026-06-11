package com.example.resersportif.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "terrains")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TerrainSportif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTerrain;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String horaire;

    @Column(nullable = false)
    private Boolean disponible;

    @Column(nullable = false)
    private Integer tarif;
}