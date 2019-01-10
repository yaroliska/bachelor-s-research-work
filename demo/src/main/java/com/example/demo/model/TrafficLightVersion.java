package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TrafficLightVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //ссылка на светофор
    @ManyToOne
    TrafficLightType trafficLightType;
    //ссылка на версию пути
}
