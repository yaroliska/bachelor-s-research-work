package com.example.demo.controller;

import com.example.demo.model.Arrow;
import com.example.demo.model.ArrowType;
import com.example.demo.repository.ArrowRepository;
import com.example.demo.repository.ArrowTypeRepository;
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
    public List<Arrow> getArrow() {
        return arrowRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addArrow(@RequestBody Arrow arrow) {
        arrowRepository.save(arrow);
    }
}
