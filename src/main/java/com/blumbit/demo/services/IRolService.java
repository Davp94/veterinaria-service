package com.blumbit.demo.services;

import java.util.List;
import java.util.Optional;

import com.blumbit.demo.dtos.CreateRolDto;
import com.blumbit.demo.dtos.RolDto;

public interface IRolService {

    List<RolDto> findAllRoles();

    Optional<RolDto> findRolById(Short id);

    RolDto createRol(CreateRolDto rolEntity);

    RolDto updateRol(CreateRolDto rolEntity, Short id);

    void deleteRol(Short id);

}
