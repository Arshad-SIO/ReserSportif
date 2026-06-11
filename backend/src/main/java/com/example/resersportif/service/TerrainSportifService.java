package com.example.resersportif.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.resersportif.entity.TerrainSportif;
import com.example.resersportif.repository.TerrainSportifRepository;

@Service
public class TerrainSportifService {

    private final TerrainSportifRepository terrainRepository;

    public TerrainSportifService(TerrainSportifRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public List<TerrainSportif> getAllTerrains() {
        return terrainRepository.findAll();
    }

    public TerrainSportif getTerrainById(Long id) {
        return terrainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Terrain introuvable."));
    }
}