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
    Double xbegin;
    Double ybegin;
    Double xend;
    Double yend;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getXbegin() {
        return xbegin;
    }

    public void setXbegin(Double xbegin) {
        this.xbegin = xbegin;
    }

    public Double getYbegin() {
        return ybegin;
    }

    public void setYbegin(Double ybegin) {
        this.ybegin = ybegin;
    }

    public Double getXend() {
        return xend;
    }

    public void setXend(Double xend) {
        this.xend = xend;
    }

    public Double getYend() {
        return yend;
    }

    public void setYend(Double yend) {
        this.yend = yend;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public void setArrows(List<Arrow> arrows) {
        this.arrows = arrows;
    }

    public List<Arrow> getArrows() {
        return arrows;
    }
}
