package com.blumbit.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class ResponsableEntity extends UsuarioEntity{

    @Id
    private Short id;

    @JoinTable(
        name = "responsable_mascota",
        joinColumns = @JoinColumn(name="responsable_id", nullable=false),
        inverseJoinColumns = @JoinColumn(name="mascota_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<MascotaEntity> mascota;

}
