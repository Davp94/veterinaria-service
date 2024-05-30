package com.blumbit.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.blumbit.demo.entities.MascotaEntity;

public interface MascotaRepository extends ListPagingAndSortingRepository<MascotaEntity, Integer>{
    
    Page<MascotaEntity> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
    
}
