package com.blumbit.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetMascotasDto {
    
    private int page;

    private int size;

    private String sortParam;

    private int order;

    private String nombre;
}
