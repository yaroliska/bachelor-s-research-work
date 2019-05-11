package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class GlobalVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String creator;
    Date date;
    String description;
    String name;

    @ManyToOne
    Station station;

    public GlobalVersion(){

    }
    public GlobalVersion(String creator,Date date,String description){
        this.creator=creator;
        this.date=date;
        this.description=description;
    }

    public Long getId() {
        return id;
    }

    public String getCreator() {
        return creator;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Station getStation() {
        return station;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
