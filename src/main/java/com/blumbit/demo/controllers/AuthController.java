package com.blumbit.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.demo.dtos.LoginDto;
import com.blumbit.demo.dtos.LoginResponse;
import com.blumbit.demo.utils.security.JWTUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginDto loginDto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);
        String jwt = this.jwtUtil.createToken(loginDto.getUsername());
        return new LoginResponse(jwt);
    }
    
}
