package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer number;
    Double xbegin;
    Double ybegin;
    Double xend;
    Double yend;

    @ManyToOne(optional = true)//, fetch = FetchType.LAZY)
    Park park;

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "arrow_path",
        joinColumns = {@JoinColumn(name = "path_id")},
        inverseJoinColumns = {@JoinColumn(name = "arrow_id")})
    List<Arrow> arrows = new ArrayList<>();*/
    public Long getId() {
        return id;
    }

    public Park getPark() {
        return park;
    }

    public Double getXbegin() {
        return xbegin;
    }

    public Double getXend() {
        return xend;
    }

    public Integer getNumber() {
        return number;
    }

    public Double getYbegin() {
        return ybegin;
    }

    public Double getYend() {
        return yend;
    }
    /*public void setArrows(List<Arrow> arrows) {
        this.arrows = arrows;
    }*/
}
