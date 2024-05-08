package com.blumbit.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.demo.dtos.CreateRolDto;
import com.blumbit.demo.dtos.RolDto;
import com.blumbit.demo.entities.RolEntity;
import com.blumbit.demo.repository.RolRepository;
import com.blumbit.demo.services.IRolService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/rol")
public class RolController {

    // @Autowired
    // private RolRepository rolRepository;

    private final IRolService rolService;

    public RolController(IRolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping()
    public List<RolDto> findAllRoles(){
        return this.rolService.findAllRoles();
    }

    @GetMapping("/{id}")
    public Optional<RolDto> findOneById(@PathVariable Short id){
        return this.rolService.findRolById(id);
    }

    @PostMapping()
    public RolDto createRol(@RequestBody CreateRolDto rol){
        return this.rolService.createRol(rol);
    }

    @PutMapping("/{id}")
    public RolDto update(@RequestBody CreateRolDto rol, @PathVariable Short id){       
        return this.rolService.updateRol(rol, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRolById(@PathVariable Short id){
        this.rolService.deleteRol(id);
    }

}
