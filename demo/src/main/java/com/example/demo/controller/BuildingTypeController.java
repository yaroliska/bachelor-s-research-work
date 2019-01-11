package com.example.demo.controller;

import com.example.demo.model.BuildingType;
import com.example.demo.repository.BuildingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/building_type")
@CrossOrigin("*")
public class BuildingTypeController {
    @Autowired
    private BuildingTypeRepository buildingTypeRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<BuildingType> getBuildingTypes() {
        return buildingTypeRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addBuildingType(@RequestBody BuildingType buildingType) {
        buildingTypeRepository.save(buildingType);
    }
}
