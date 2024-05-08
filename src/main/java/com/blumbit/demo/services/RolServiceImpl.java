package com.blumbit.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.blumbit.demo.dtos.CreateRolDto;
import com.blumbit.demo.dtos.RolDto;
import com.blumbit.demo.entities.RolEntity;
import com.blumbit.demo.repository.RolRepository;

@Service
public class RolServiceImpl implements IRolService{

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<RolDto> findAllRoles() {
        List<RolEntity> roles = this.rolRepository.findAll();
        List<RolDto> rolesDto = new ArrayList<RolDto>();
        for (RolEntity rol : roles) {
            RolDto rolDto = new RolDto();
            rolDto.setId(rol.getId());
            rolDto.setNombre(rol.getNombre());
            rolDto.setDescripcion(rol.getDescripcion());
            rolesDto.add(rolDto);
        }
        return rolesDto;
    }

    @Override
    public Optional<RolDto> findRolById(Short id) {
        RolEntity rolEntity = this.rolRepository.findById(id).get();
        RolDto rolDto = new RolDto();
        if(rolEntity != null){
            rolDto.setId(rolEntity.getId());
            rolDto.setNombre(rolEntity.getNombre());
            rolDto.setDescripcion(rolEntity.getDescripcion());
        }
        return Optional.of(rolDto);
    }

    @Override
    public RolDto createRol(CreateRolDto createRolDto) {
        RolEntity rolEntity = new RolEntity();
        rolEntity.setNombre(createRolDto.getNombre());
        rolEntity.setDescripcion(createRolDto.getDescripcion());
        rolEntity = this.rolRepository.save(rolEntity);
        RolDto rolDto = new RolDto();
        rolDto.setId(rolEntity.getId());
        rolDto.setNombre(rolEntity.getNombre());
        rolDto.setDescripcion(rolEntity.getDescripcion());
        return rolDto;
    }

    @Override
    public RolDto updateRol(CreateRolDto createRolDto, Short id) {
        RolEntity rolEntity = this.rolRepository.findById(id).get();
        rolEntity.setNombre(createRolDto.getNombre());
        rolEntity.setDescripcion(createRolDto.getDescripcion());
        rolEntity = this.rolRepository.save(rolEntity);
        RolDto rolDto = new RolDto();
        rolDto.setId(rolEntity.getId());
        rolDto.setNombre(rolEntity.getNombre());
        rolDto.setDescripcion(rolEntity.getDescripcion());
        return rolDto;
    }

    @Override
    public void deleteRol(Short id) {
        this.rolRepository.deleteById(id);
        
    }
    
}
