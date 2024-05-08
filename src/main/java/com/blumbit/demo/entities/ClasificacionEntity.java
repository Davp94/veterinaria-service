package com.blumbit.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clasificacion", schema = "public")
public class ClasificacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Short id;

    private String nombre;

    private String descripcion;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TipoEntity tipo;


}
