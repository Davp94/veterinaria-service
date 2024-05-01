package com.blumbit.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MascotaEntity {

    @Id
    @Column(name = "mas_id")
    private Integer id;

    @Column(name = "mas_nombre")
    private String nombre;

    @Column(name = "mas_tipo")
    private String tipo;
}
