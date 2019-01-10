package com.example.demo.controller;

import com.example.demo.model.Park;
import com.example.demo.model.Station;
import com.example.demo.repository.ParkRepository;
import com.example.demo.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/park")
@CrossOrigin("*")
public class ParkController {
    @Autowired
    private ParkRepository parkRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<Park> getParks() {
        return parkRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addPark(@RequestBody Park park) {
        parkRepository.save(park);
    }

}
