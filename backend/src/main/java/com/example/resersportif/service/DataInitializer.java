package com.example.resersportif.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.resersportif.entity.TerrainSportif;
import com.example.resersportif.repository.TerrainSportifRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TerrainSportifRepository terrainRepository;

    public DataInitializer(TerrainSportifRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (terrainRepository.count() == 0) {

            terrainRepository.save(
                TerrainSportif.builder()
                    .adresse("Stade Municipal Paris")
                    .horaire("08h00 - 22h00")
                    .disponible(true)
                    .tarif(20)
                    .build()
            );

            terrainRepository.save(
                TerrainSportif.builder()
                    .adresse("Tennis Club Lyon")
                    .horaire("09h00 - 20h00")
                    .disponible(true)
                    .tarif(15)
                    .build()
            );

            terrainRepository.save(
                TerrainSportif.builder()
                    .adresse("Gymnase Basket Marseille")
                    .horaire("10h00 - 23h00")
                    .disponible(false)
                    .tarif(25)
                    .build()
            );
        }
    }
}