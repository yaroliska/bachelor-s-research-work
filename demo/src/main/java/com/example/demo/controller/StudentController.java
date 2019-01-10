package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    @CrossOrigin("*")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    @CrossOrigin("*")
    public void addStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }
}
