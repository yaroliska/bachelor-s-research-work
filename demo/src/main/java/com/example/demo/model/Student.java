package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;
    String lastName;
    Integer age;

    @ManyToOne
    Department department;

}
