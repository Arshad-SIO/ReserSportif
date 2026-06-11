package com.example.resersportif.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "administrations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Administration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    private String nom;

    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
}