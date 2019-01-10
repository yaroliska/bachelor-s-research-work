package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TrafficLightVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    TrafficLight trafficLight;
    @ManyToOne
    TrafficLightType trafficLightType;
    @ManyToOne
    PathVersion pathVersion;
}
