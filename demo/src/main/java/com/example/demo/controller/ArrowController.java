package com.example.demo.controller;


import com.example.demo.model.Arrow;
import com.example.demo.repository.ArrowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arrow")
@CrossOrigin("*")

public class ArrowController {
    @Autowired
    private ArrowRepository arrowRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<Arrow> getArrows() {return arrowRepository.findAll();}

    @PostMapping
    @CrossOrigin("*")
    public void addDepartment(@RequestBody Arrow arrow) {
        arrowRepository.save(arrow);
    }
}
