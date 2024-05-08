package com.blumbit.demo.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class MascotaEntity {

    @Id
    @Column(name = "mas_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "mas_nombre")
    private String nombre;

    @Column(name = "mas_tipo")
    private String tipo;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ClasificacionEntity clasificacion;
    
    @ManyToMany(mappedBy = "mascota")
    private List<ResponsableEntity> responsable;

    private Short usuario_creacion;
    
    private Short usuario_modificacion;

    private Short usuario_baja;

    private LocalDate fecha_creacion;

    private LocalDate fecha_modificacion;

    private LocalDate fecha_baja;
}
