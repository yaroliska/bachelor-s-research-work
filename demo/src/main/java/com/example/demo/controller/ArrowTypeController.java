package com.example.demo.controller;

import com.example.demo.model.ArrowType;
import com.example.demo.repository.ArrowTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arrow_type")
@CrossOrigin("*")
public class ArrowTypeController {
    @Autowired
    private ArrowTypeRepository arrowTypeRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<ArrowType> getArrowTypes() {
        return arrowTypeRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addArrowType(@RequestBody ArrowType arrowType) {
        arrowTypeRepository.save(arrowType);
    }
}
