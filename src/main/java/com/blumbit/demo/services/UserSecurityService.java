package com.blumbit.demo.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blumbit.demo.entities.UsuarioEntity;
import com.blumbit.demo.repository.UsuarioRepository;

@Service
public class UserSecurityService implements UserDetailsService{

    private final UsuarioRepository usuarioRepository;

    
    public UserSecurityService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = this.usuarioRepository.findByNombre(username)
        .orElseThrow(()->new UsernameNotFoundException("Usuario "+username+" no encontrado"));
        return User.builder()
                .username(usuario.getNombre())
                .password(usuario.getPassword())
                .build();
    }   

}
