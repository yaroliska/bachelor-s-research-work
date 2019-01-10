package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Arrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double arrow_x_coordinate;
    Double arrow_y_coordinate;
    Integer arrow_number;
    String arrow_type;
}