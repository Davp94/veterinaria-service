package com.blumbit.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TipoEntity {

    @Id
    private Short id;

    private String nombre;

    private String descripcion;

}
