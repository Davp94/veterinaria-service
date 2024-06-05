package com.blumbit.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.blumbit.demo.services.PdfService;

import jakarta.servlet.http.HttpServletResponse;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PdfController {

    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/pdf")
    public void getMethodName(HttpServletResponse response) {
        try {
            Path file = Paths.get(this.pdfService.generateRolesPdf().getAbsolutePath());
            if(Files.exists(file)){
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition", "attachment; filename"+file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().close();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
