package com.blumbit.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class VeterinarioEntity extends UsuarioEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Short id;

    private String matricula;

    private String descripcion;
}
