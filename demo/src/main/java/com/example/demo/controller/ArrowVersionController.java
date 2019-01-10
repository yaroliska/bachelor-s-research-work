package com.example.demo.controller;

import com.example.demo.model.ArrowVersion;
import com.example.demo.repository.ArrowVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arrowVersion")
@CrossOrigin("*")
public class ArrowVersionController {
    @Autowired
    private ArrowVersionRepository arrowVersionRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<ArrowVersion> getArrowVersions() {return arrowVersionRepository.findAll();}

    @PostMapping
    @CrossOrigin("*")
    public void addArrowVersion(@RequestBody ArrowVersion arrowVersion) {arrowVersionRepository.save(arrowVersion);}
}
