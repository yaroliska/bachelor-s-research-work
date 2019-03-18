package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property="id")
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer number;
    Double xBegin;
    Double yBegin;
    Double xEnd;
    Double yEnd;

    @ManyToOne(optional = true)//, fetch = FetchType.LAZY)
    Park park;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "arrow_path",
        joinColumns = {@JoinColumn(name = "path_id")},
        inverseJoinColumns = {@JoinColumn(name = "arrow_id")})
    List<Arrow> arrows = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setArrows(List<Arrow> arrows) {
        this.arrows = arrows;
    }
}
