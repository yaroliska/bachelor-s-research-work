package com.example.demo.controller;

import com.example.demo.model.BuildingType;
import com.example.demo.model.BuildingVersion;
import com.example.demo.repository.BuildingTypeRepository;
import com.example.demo.repository.BuildingVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/building_version")
@CrossOrigin("*")
public class BuildingVersionController {
    @Autowired
    private BuildingVersionRepository buildingVersionRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<BuildingVersion> getBuildingVersions() {
        return buildingVersionRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addBuildingVersion(@RequestBody BuildingVersion buildingVersion) {
        buildingVersionRepository.save(buildingVersion);
    }
}
