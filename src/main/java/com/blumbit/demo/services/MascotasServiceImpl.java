package com.blumbit.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.blumbit.demo.dtos.CreateMascotaDto;
import com.blumbit.demo.dtos.GetMascotasDto;
import com.blumbit.demo.entities.MascotaEntity;
import com.blumbit.demo.repository.MascotaRepository;
import com.blumbit.demo.repository.MascotasOperationRepository;

@Service
public class MascotasServiceImpl implements IMascotasService{

    private final MascotaRepository mascotaRepository;

    private final MascotasOperationRepository mascotasOperationRepository;
    
    public MascotasServiceImpl(MascotaRepository mascotaRepository, MascotasOperationRepository mascotasOperationRepository) {
        this.mascotaRepository = mascotaRepository;
        this.mascotasOperationRepository = mascotasOperationRepository;
    }

    @Override
    public Page<MascotaEntity> findByNombreContainingIgnoreCase(GetMascotasDto getMascotasDto) {
        Pageable pageable = PageRequest.of(getMascotasDto.getPage(), getMascotasDto.getSize(),
                Sort.by(getMascotasDto.getOrder() == 1 ? Direction.ASC : Direction.DESC, getMascotasDto.getSortParam()));    
        return this.mascotaRepository.findByNombreContainingIgnoreCase(getMascotasDto.getNombre(), pageable);
    }

    @Override
    public MascotaEntity createMascota(CreateMascotaDto createMascotaDto) {
        MascotaEntity mascotaEntity = new MascotaEntity();
        mascotaEntity.setNombre(createMascotaDto.getNombre());
        mascotaEntity.setTipo(createMascotaDto.getTipo());
        return this.mascotasOperationRepository.save(mascotaEntity);
    }

}
