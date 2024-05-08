package com.blumbit.demo.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.demo.entities.RolEntity;

public interface RolRepository extends ListCrudRepository<RolEntity, Short>{

    //TODO QUERIES SQL NATIVE, JPA QUERY METHODS, JPQL

}
