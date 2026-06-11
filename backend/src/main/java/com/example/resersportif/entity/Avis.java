package com.example.resersportif.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "avis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvis;

    @Column(nullable = false)
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Administration administration;
}