package com.blumbit.demo.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blumbit.demo.entities.UsuarioEntity;
import com.blumbit.demo.repository.UsuarioRepository;



@Component
public class SeedInitialData implements CommandLineRunner{

    private final UsuarioRepository usuarioRepository;

    public SeedInitialData(UsuarioRepository usuariosRepository){
        this.usuarioRepository = usuariosRepository;
    }

    @Override
    public void run(String... args) {
        UsuarioEntity usuario1 = new UsuarioEntity();
        usuario1.setNombre("usuario1");
        usuario1.setPassword("$2a$12$nDbdBtjkAobDGzPrUDWys.AodVDndOXjYifuO6WbW.RY12XatEexa");
        usuario1.setCorreo("test@test.com");

        this.usuarioRepository.saveAll(List.of(usuario1));
    }

}
