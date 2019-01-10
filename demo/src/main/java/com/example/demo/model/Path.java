package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "arrow_path",
        joinColumns = {@JoinColumn(name = "path_id")},
        inverseJoinColumns = {@JoinColumn(name = "arrow_id")})
    List<Arrow> arrows = new ArrayList<>();

    @Override
    public String toString() {
        return this.id.toString();
    }

    public Long getId() {
        return id;
    }

    public void setArrows(List<Arrow> arrows) {
        this.arrows = arrows;
    }
}
