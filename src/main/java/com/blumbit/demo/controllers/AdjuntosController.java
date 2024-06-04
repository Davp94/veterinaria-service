package com.blumbit.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blumbit.demo.dtos.AdjuntosRequest;
import com.blumbit.demo.dtos.AdjuntosResponse;
import com.blumbit.demo.services.IAdjuntosService;

@RestController
@RequestMapping("/adjuntos")
public class AdjuntosController {
    private final IAdjuntosService adjuntosService;

    public AdjuntosController(IAdjuntosService adjuntosService) {
        this.adjuntosService = adjuntosService;
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestPart("file")MultipartFile file) throws Exception{
        if(file == null){
            return ResponseEntity.badRequest().body("Error, archivo adjunto necesario");
        }
        AdjuntosResponse adjuntosResponse = new AdjuntosResponse();
        adjuntosResponse.setFilePath(this.adjuntosService.createImage(new AdjuntosRequest(file.getOriginalFilename(), file)));
        return ResponseEntity.ok(adjuntosResponse);
    }
}

