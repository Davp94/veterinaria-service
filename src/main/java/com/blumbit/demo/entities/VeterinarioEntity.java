package com.blumbit.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class VeterinarioEntity extends UsuarioEntity{

    @Id
    private Short id;

    private String matricula;

    private String descripcion;
}
