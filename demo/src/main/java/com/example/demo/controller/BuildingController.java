package com.example.demo.controller;

import com.example.demo.model.Building;
import com.example.demo.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/building")
@CrossOrigin("*")
public class BuildingController {
    @Autowired
    private BuildingRepository buildingRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<Building> getBuildings() {
        return buildingRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addBuilding(@RequestBody Building building) {
        buildingRepository.save(building);
    }
}
