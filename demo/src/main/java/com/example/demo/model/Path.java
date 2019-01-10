package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer number;
    Double xBegin;
    Double yBegin;
    Double xEnd;
    Double yEnd;

    @ManyToOne
    Park park;
}
