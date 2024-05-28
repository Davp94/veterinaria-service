package com.blumbit.demo.utils.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JWTUtil {
    private static String SECRET_KEY = "v3t3r1n@r1@";
    private static Algorithm ALGORITHM = Algorithm.HMAC512(SECRET_KEY);

    public String createToken(String username){

        return JWT.create()
                    .withSubject(username)
                    .withIssuer("veterinaria-service")
                    .withIssuedAt(new Date())
                    .sign(ALGORITHM);

    }

    public boolean isValidToken(String token){
        try {
            JWT.require(ALGORITHM)
                .build()
                .verify(token);
            return true;
        } catch (Exception e) {
           return false;
        }  
    }

    public String getUsername(String jwt){
        return JWT.require(ALGORITHM)
                    .build()
                    .verify(jwt)
                    .getSubject();
    }
}
