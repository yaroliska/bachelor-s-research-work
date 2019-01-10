package com.example.demo.controller;


import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin("*")
public class DepartmentController {


    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addDepartment(@RequestBody Department department) {
        departmentRepository.save(department);
    }
}
