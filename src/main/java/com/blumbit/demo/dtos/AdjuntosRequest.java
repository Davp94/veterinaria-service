package com.blumbit.demo.dtos;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AdjuntosRequest {
    private String title;

    private MultipartFile file;
}
