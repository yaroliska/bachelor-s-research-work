package com.example.demo.controller;

import com.example.demo.model.Station;
import com.example.demo.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/station")
@CrossOrigin("*")
public class StationController {
    @Autowired
    private StationRepository stationRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<Station> getStations() {
        return stationRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public Long addStation(@RequestBody Station station) {
        stationRepository.save(station);
        return station.getId();
    }

}
