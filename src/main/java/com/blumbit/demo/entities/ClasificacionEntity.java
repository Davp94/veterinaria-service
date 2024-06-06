package com.blumbit.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clasificacion", schema = "public")
@Getter
@Setter
public class ClasificacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Short id;

    private String nombre;

    private String descripcion;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TipoEntity tipo;


}
