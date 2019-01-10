package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Arrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    Double x;
    Double y;

    @ManyToOne
    ArrowType arrowType;
}
