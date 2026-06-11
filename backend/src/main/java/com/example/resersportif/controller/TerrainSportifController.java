package com.example.resersportif.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resersportif.entity.TerrainSportif;
import com.example.resersportif.service.TerrainSportifService;

@RestController
@RequestMapping("/api/terrains")
public class TerrainSportifController {

    private final TerrainSportifService terrainService;

    public TerrainSportifController(TerrainSportifService terrainService) {
        this.terrainService = terrainService;
    }

    @GetMapping
    public List<TerrainSportif> getAllTerrains() {
        return terrainService.getAllTerrains();
    }
}