package com.example.demo.controller;

import com.example.demo.model.Arrow;
import com.example.demo.model.Path;
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
    public List<Arrow> getArrow() {
        List<Arrow> ars = arrowRepository.findAll();
//        for(Arrow ar : ars){
//            for(Path path : ar.getPaths()){
//                path.setArrows(null);
//            }
//        }

//        Path p = ars.get(0).getPaths().get(0);
//        long pn = p.getId();
//        System.out.println("vot");
        return ars;//arrowRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addArrow(@RequestBody Arrow arrow) {
        arrowRepository.save(arrow);
    }
}
