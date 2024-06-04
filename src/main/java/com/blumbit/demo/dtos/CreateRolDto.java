package com.blumbit.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRolDto {
    
    @NotNull(message = "El campo no puede ser nulo")
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(min = 5, max = 15, message = "El campo debe tener entre 5 y 15 caracteres")
    private String nombre;

    @NotNull(message = "El campo no puede ser nulo")
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 100, message = "El campo debe tener maximo 100 caracteres")
    private String descripcion;
}
