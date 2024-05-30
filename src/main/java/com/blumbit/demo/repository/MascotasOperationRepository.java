package com.blumbit.demo.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.demo.entities.MascotaEntity;

public interface MascotasOperationRepository extends ListCrudRepository<MascotaEntity, Integer>{

}
