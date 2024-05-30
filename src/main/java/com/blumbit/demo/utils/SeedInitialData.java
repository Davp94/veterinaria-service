package com.blumbit.demo.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blumbit.demo.entities.MascotaEntity;
import com.blumbit.demo.entities.UsuarioEntity;
import com.blumbit.demo.repository.MascotasOperationRepository;
import com.blumbit.demo.repository.UsuarioRepository;



@Component
public class SeedInitialData implements CommandLineRunner{

    private final UsuarioRepository usuarioRepository;
    private final MascotasOperationRepository mascotasOperationRepository;

    public SeedInitialData(UsuarioRepository usuariosRepository, MascotasOperationRepository mascotasOperationRepository){
        this.usuarioRepository = usuariosRepository;
        this.mascotasOperationRepository = mascotasOperationRepository;
    }

    @Override
    public void run(String... args) {
        UsuarioEntity usuario1 = new UsuarioEntity();
        usuario1.setNombre("usuario1");
        usuario1.setPassword("$2a$12$nDbdBtjkAobDGzPrUDWys.AodVDndOXjYifuO6WbW.RY12XatEexa");
        usuario1.setCorreo("test@test.com");

        this.usuarioRepository.saveAll(List.of(usuario1));

        MascotaEntity mascota1 = new MascotaEntity();
        mascota1.setNombre("firulais");
        mascota1.setTipo("cooker");

        MascotaEntity mascota2 = new MascotaEntity();
        mascota2.setNombre("lupita");
        mascota2.setTipo("salchicha");

        MascotaEntity mascota3 = new MascotaEntity();
        mascota3.setNombre("slinky");
        mascota3.setTipo("terrier");

        MascotaEntity mascota4 = new MascotaEntity();
        mascota4.setNombre("teka");
        mascota4.setTipo("labrador");

        MascotaEntity mascota5 = new MascotaEntity();
        mascota5.setNombre("boby");
        mascota5.setTipo("Pastor aleman");

        this.mascotasOperationRepository.saveAll(List.of(mascota1, mascota2, mascota3, mascota4, mascota5));
    }

}
