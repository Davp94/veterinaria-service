package com.blumbit.demo.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.demo.dtos.GetMascotasDto;
import com.blumbit.demo.entities.MascotaEntity;
import com.blumbit.demo.services.IMascotasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mascotas")
public class MascotasController {

    private final IMascotasService mascotasService;

    public MascotasController(IMascotasService mascotasService) {
        this.mascotasService = mascotasService;
    }

    @GetMapping
    public Page<MascotaEntity> findAllMascotas(@RequestParam @Valid int page, @RequestParam int size, @RequestParam String sortParam,
    @RequestParam int order, @RequestParam String nombre){
        return this.mascotasService.findByNombreContainingIgnoreCase(new GetMascotasDto(page, size, sortParam, order, nombre));
    }

}
