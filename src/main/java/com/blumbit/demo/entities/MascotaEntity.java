package com.blumbit.demo.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MascotaEntity {

    @Id
    @Column(name = "mas_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "mas_nombre")
    private String nombre;

    @Column(name = "mas_tipo")
    private String tipo;

    @Column(name = "mas_imagen")
    private String imagen;

    @ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ClasificacionEntity clasificacion;
    
    // @ManyToMany(mappedBy = "mascota")
    // private List<ResponsableEntity> responsable;

    private Short usuario_creacion;
    
    private Short usuario_modificacion;

    private Short usuario_baja;

    private LocalDateTime fecha_creacion;

    private LocalDateTime fecha_modificacion;

    private LocalDateTime fecha_baja;

    @PrePersist
    private void addFechaCreacion(){
        this.fecha_creacion = LocalDateTime.now();
    }
}
