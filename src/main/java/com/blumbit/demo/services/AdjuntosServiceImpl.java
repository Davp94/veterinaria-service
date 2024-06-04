package com.blumbit.demo.services;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.blumbit.demo.dtos.AdjuntosRequest;
import com.blumbit.demo.utils.security.FilesDefinition;

@Service
public class AdjuntosServiceImpl implements IAdjuntosService{

    @Override
    public String createImage(AdjuntosRequest adjuntosRequest) throws Exception {
        
        if(validateADjuntosImage(adjuntosRequest)){
            String filePath = FilesDefinition.PROJECT_FILES_PATH + File.separator + adjuntosRequest.getTitle();
            byte[] bytes = adjuntosRequest.getFile().getBytes();
            FileOutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(bytes);
            outputStream.close();
        }else {
            throw new Exception ("Formato de imagen no valido");
        }
        return adjuntosRequest.getTitle();
    }

    private boolean validateADjuntosImage(AdjuntosRequest adjuntosRequest){
        String contentType = adjuntosRequest.getFile().getContentType();
        if(contentType == null) return false;
        return contentType.equals(MediaType.IMAGE_PNG_VALUE) || 
        contentType.equals(MediaType.IMAGE_JPEG_VALUE);
    }

}
