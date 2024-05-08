package com.blumbit.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class RolEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "rol_id")
    private Short id;

    @Column(name = "rol_nombre")
    private String nombre;

    @Column(name = "rol_descripcion")
    private String descripcion;

    private Short usuarioCreacion;

}
