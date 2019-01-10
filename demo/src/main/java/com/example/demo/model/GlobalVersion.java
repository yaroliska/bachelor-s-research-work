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

    @ManyToOne
    Station station;

    public GlobalVersion(){

    }
    public GlobalVersion(String creator,Date date,String description){
        this.creator=creator;
        this.date=date;
        this.description=description;
    }

}
