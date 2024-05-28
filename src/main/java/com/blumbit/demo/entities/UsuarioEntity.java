package com.blumbit.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usu_id")
    private Short id;

    @Column(nullable = false, length = 100, name = "usu_nombre", unique = true)
    private String nombre;

    @Column(name = "usu_correo")
    private String correo;

    @Column(name = "usu_password")
    private String password;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RolEntity rol;

}
