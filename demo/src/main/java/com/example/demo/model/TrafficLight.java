package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TrafficLight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double x;
    Double y;
    @ManyToOne
    TrafficLightType trafficLightType;
    //ссылка на путь
}
