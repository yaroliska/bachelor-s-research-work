package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Data
@Entity
public class PathVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer number;
    Double xBegin;
    Double yBegin;
    Double xEnd;
    Double yEnd;
    @ManyToOne
    Path path;
    @ManyToOne
    Park park;
    @ManyToOne
    GlobalVersion globalVersion;
}
