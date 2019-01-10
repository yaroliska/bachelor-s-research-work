package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ArrowVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String arrowVersionName; //название версии стрелки
    String arrowDate;//дата создания версии стрелки

    @ManyToOne
    Arrow arrow;
}





