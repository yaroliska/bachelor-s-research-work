package com.example.demo.controller;

import com.example.demo.model.TrafficLightVersion;
import com.example.demo.repository.TrafficLightVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traffic_light_version")
@CrossOrigin("*")
public class TrafficLightVersionController {
    @Autowired
    private TrafficLightVersionRepository trafficLightVersionRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<TrafficLightVersion> getTrafficLightVersion() {
        return trafficLightVersionRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addTrafficLightVersion(@RequestBody TrafficLightVersion trafficLightVersion) {
        trafficLightVersionRepository.save(trafficLightVersion);
    }
}
