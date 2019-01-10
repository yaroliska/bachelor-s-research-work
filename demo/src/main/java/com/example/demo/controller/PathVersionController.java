package com.example.demo.controller;

import com.example.demo.model.Path;
import com.example.demo.model.PathVersion;
import com.example.demo.repository.PathRepository;
import com.example.demo.repository.PathVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/path_version")
@CrossOrigin("*")
public class PathVersionController {
    @Autowired
    private PathVersionRepository pathVersionRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<PathVersion> getPathVersions() {
        return pathVersionRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addPathVersion(@RequestBody PathVersion pathVersion) {
        pathVersionRepository.save(pathVersion);
    }
}
