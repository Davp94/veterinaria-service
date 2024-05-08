package com.blumbit.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Short id;

    private String nombre;

    private String descripcion;

}
