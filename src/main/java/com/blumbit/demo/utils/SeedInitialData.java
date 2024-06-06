package com.blumbit.demo.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blumbit.demo.entities.ClasificacionEntity;
import com.blumbit.demo.entities.MascotaEntity;
import com.blumbit.demo.entities.RolEntity;
import com.blumbit.demo.entities.UsuarioEntity;
import com.blumbit.demo.repository.ClasificacionRepository;
import com.blumbit.demo.repository.MascotasOperationRepository;
import com.blumbit.demo.repository.RolRepository;
import com.blumbit.demo.repository.UsuarioRepository;



@Component
public class SeedInitialData implements CommandLineRunner{

    private final UsuarioRepository usuarioRepository;
    private final MascotasOperationRepository mascotasOperationRepository;
    private final RolRepository rolRepository;
    private final ClasificacionRepository clasificacionRepository;

    public SeedInitialData(UsuarioRepository usuariosRepository, MascotasOperationRepository mascotasOperationRepository, ClasificacionRepository clasificacionRepository, RolRepository rolRepository){
        this.usuarioRepository = usuariosRepository;
        this.mascotasOperationRepository = mascotasOperationRepository;
        this.rolRepository = rolRepository;
        this.clasificacionRepository = clasificacionRepository;
    }

    @Override
    public void run(String... args) {

        RolEntity rol1 = new RolEntity();
        rol1.setNombre("ADMINISTRADOR");
        rol1.setDescripcion("Rol ADministrador");

        RolEntity rol2 = new RolEntity();
        rol2.setNombre("VETERINARIO");
        rol2.setDescripcion("Rol Veterinario");

        RolEntity rol3 = new RolEntity();
        rol3.setNombre("RESPONSABLE");
        rol3.setDescripcion("Rol Responsable");

        List<RolEntity> rolesCreated = this.rolRepository.saveAll(List.of(rol1, rol2, rol3));

        UsuarioEntity usuario1 = new UsuarioEntity();
        usuario1.setNombre("usuario1");
        usuario1.setPassword("$2a$12$nDbdBtjkAobDGzPrUDWys.AodVDndOXjYifuO6WbW.RY12XatEexa");
        usuario1.setCorreo("test@test.com");
        usuario1.setRol(rolesCreated.getFirst());
        this.usuarioRepository.saveAll(List.of(usuario1));

        ClasificacionEntity clasificacionEntity1 = new ClasificacionEntity();
        clasificacionEntity1.setNombre("Chihuahua");
        clasificacionEntity1.setDescripcion("raza muy pequeña");

        ClasificacionEntity clasificacionEntity2 = new ClasificacionEntity();
        clasificacionEntity2.setNombre("Salchicha");
        clasificacionEntity2.setDescripcion("raza pequeña");

        ClasificacionEntity clasificacionEntity3 = new ClasificacionEntity();
        clasificacionEntity3.setNombre("Husky");
        clasificacionEntity3.setDescripcion("raza grande");

        ClasificacionEntity clasificacionEntity4 = new ClasificacionEntity();
        clasificacionEntity4.setNombre("San Bernardo");
        clasificacionEntity4.setDescripcion("raza grande");

        ClasificacionEntity clasificacionEntity5 = new ClasificacionEntity();
        clasificacionEntity5.setNombre("Shar pei");
        clasificacionEntity5.setDescripcion("raza mediana");

        List<ClasificacionEntity> clasificacionesCreated = this.clasificacionRepository.saveAll(List.of(clasificacionEntity1, clasificacionEntity2, clasificacionEntity3, clasificacionEntity4, clasificacionEntity5));

        MascotaEntity mascota1 = new MascotaEntity();
        mascota1.setNombre("firulais");
        mascota1.setTipo("cooker");
        mascota1.setClasificacion(clasificacionesCreated.getFirst());
        MascotaEntity mascota2 = new MascotaEntity();
        mascota2.setNombre("lupita");
        mascota2.setTipo("salchicha");
        mascota2.setClasificacion(clasificacionesCreated.get(2));
        MascotaEntity mascota3 = new MascotaEntity();
        mascota3.setNombre("slinky");
        mascota3.setTipo("terrier");
        mascota3.setClasificacion(clasificacionesCreated.get(3));
        MascotaEntity mascota4 = new MascotaEntity();
        mascota4.setNombre("teka");
        mascota4.setTipo("labrador");
        mascota4.setClasificacion(clasificacionesCreated.get(0));
        MascotaEntity mascota5 = new MascotaEntity();
        mascota5.setNombre("boby");
        mascota5.setTipo("Pastor aleman");
        mascota5.setClasificacion(clasificacionesCreated.getLast());
        this.mascotasOperationRepository.saveAll(List.of(mascota1, mascota2, mascota3, mascota4, mascota5));
    }

}
