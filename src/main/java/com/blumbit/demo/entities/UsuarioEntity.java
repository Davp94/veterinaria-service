package com.blumbit.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UsuarioEntity {

    @Id
    @Column(name = "usu_id")
    private Short id;

    @Column(nullable = false, length = 100, name = "usu_nombre")
    private String nombre;

    @Column(name = "usu_correo")
    private String correo;

    @Column(name = "usu_password")
    private String password;

}
