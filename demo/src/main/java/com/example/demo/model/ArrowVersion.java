package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Data
@Entity
public class ArrowVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    Double x;
    Double y;

    @ManyToOne
    Arrow arrow;

    @ManyToOne
    GlobalVersion globalVersion;

    @ManyToOne
    ArrowType arrowType;
}
