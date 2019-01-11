package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "arrow_version_path_version",
            joinColumns = {@JoinColumn(name = "path_version_id")},
            inverseJoinColumns = {@JoinColumn(name = "arrow_version_id")})
    List<ArrowVersion> arrow_versions = new ArrayList<>();

    @Override
    public String toString() {
        return this.id.toString();
    }

    public Long getId() {
        return id;
    }

    public void setArrowVersions(List<ArrowVersion> arrow_versions) {
        this.arrow_versions = arrow_versions;
    }
}
