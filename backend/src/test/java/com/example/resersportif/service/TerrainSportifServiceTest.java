package com.example.resersportif.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.resersportif.entity.TerrainSportif;
import com.example.resersportif.repository.TerrainSportifRepository;

public class TerrainSportifServiceTest {

    @Test
    void getAllTerrains_shouldReturnListOfTerrains() {
        TerrainSportifRepository terrainRepository =
                Mockito.mock(TerrainSportifRepository.class);

        TerrainSportifService terrainService =
                new TerrainSportifService(terrainRepository);

        TerrainSportif terrain = TerrainSportif.builder()
                .idTerrain(1L)
                .adresse("Stade Municipal Paris")
                .horaire("08h00 - 22h00")
                .disponible(true)
                .tarif(20)
                .build();

        when(terrainRepository.findAll()).thenReturn(List.of(terrain));

        List<TerrainSportif> result = terrainService.getAllTerrains();

        assertEquals(1, result.size());
        assertEquals("Stade Municipal Paris", result.get(0).getAdresse());
    }
}