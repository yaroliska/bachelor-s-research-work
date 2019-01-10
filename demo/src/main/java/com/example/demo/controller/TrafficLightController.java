package com.example.demo.controller;

import com.example.demo.model.TrafficLight;
import com.example.demo.repository.TrafficLightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traffic_light")
@CrossOrigin("*")
public class TrafficLightController {
    @Autowired
    private TrafficLightRepository trafficLightRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<TrafficLight> getTrafficLights() {
        return trafficLightRepository.findAll();
    }
    @PostMapping
    @CrossOrigin("*")
    public void addTrafficLight(@RequestBody TrafficLight trafficLight) {
        trafficLightRepository.save(trafficLight);
    }
}
