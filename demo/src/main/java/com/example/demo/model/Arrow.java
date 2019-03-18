package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property="id")
public class Arrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    Double x;
    Double y;

    @ManyToOne
    ArrowType arrowType;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST},
            mappedBy = "arrows")

    private List<Path> paths = new ArrayList<>();

    public List<Path> getPaths() {
        return paths;
    }

}
