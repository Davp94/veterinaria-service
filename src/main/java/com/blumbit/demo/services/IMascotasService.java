package com.blumbit.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.blumbit.demo.dtos.CreateMascotaDto;
import com.blumbit.demo.dtos.GetMascotasDto;
import com.blumbit.demo.entities.MascotaEntity;

public interface IMascotasService {

    Page<MascotaEntity> findByNombreContainingIgnoreCase(GetMascotasDto getMascotasDto);

    MascotaEntity createMascota(CreateMascotaDto createMascotaDto);
}
