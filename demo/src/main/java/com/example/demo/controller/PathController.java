package com.example.demo.controller;

import com.example.demo.model.Path;
import com.example.demo.repository.PathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/path")
@CrossOrigin("*")
public class PathController {
    @Autowired
    private PathRepository pathRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<Path> getPaths() {
        return pathRepository.findAll();
    }

    @PostMapping//("add")
    @CrossOrigin("*")
    public void addPath(@RequestBody Path path) {
        pathRepository.save(path);
    }

}
