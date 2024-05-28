package com.blumbit.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.demo.entities.UsuarioEntity;

public interface UsuarioRepository extends ListCrudRepository<UsuarioEntity, Short>{
    //select * from usuario where nombre like ?nombre
    Optional<UsuarioEntity> findByNombre(String nombre);

}
