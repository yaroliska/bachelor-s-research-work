package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST},
            mappedBy = "arrows")
    private List<Path> paths = new ArrayList<>();

    public List<Path> getPaths() {
        return paths;
    }

}
