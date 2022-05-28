package com.example.demo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vuelos")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String origen;
    @Column
    private String destino;
    @Column
    private String companyia;
    @Column
    private float precio;
    @Column
    private String fechainicio;
    @Column
    private String fechafin;
    @Column
    private int asientos;



}
