package com.blumbit.demo.services;

import com.blumbit.demo.dtos.AdjuntosRequest;

public interface IAdjuntosService {
    String createImage(AdjuntosRequest adjuntosRequest) throws Exception;
}
