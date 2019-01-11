package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST},
            mappedBy = "arrow_versions")
    private List<PathVersion> pathVersions = new ArrayList<>();

    public List<PathVersion> getPathVersions() {
        return pathVersions;
    }

}
