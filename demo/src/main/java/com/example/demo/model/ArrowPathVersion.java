package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ArrowPathVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    PathVersion pathVersion;
    @ManyToOne
    ArrowVersion arrowVersion;
}
