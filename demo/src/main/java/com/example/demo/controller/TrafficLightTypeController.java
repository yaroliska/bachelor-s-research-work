package com.example.demo.controller;

import com.example.demo.model.TrafficLightType;
import com.example.demo.repository.TrafficLightTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/light_traffic_type")
@CrossOrigin("*")
public class TrafficLightTypeController {
    @Autowired
    private TrafficLightTypeRepository trafficLightTypeRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<TrafficLightType> getTrafficLightType() {
        return trafficLightTypeRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addTrafficLightType(@RequestBody TrafficLightType trafficLightType) {
        trafficLightTypeRepository.save(trafficLightType);
    }

}
