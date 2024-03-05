package com.coppel.demo.services;

import java.util.List;

import com.coppel.demo.dtos.DataBaseDto;
import com.coppel.demo.entities.testing.CasoPrueba;

public interface ICasoPruebaService {

    List<CasoPrueba> getCasosDePrueba();

    List<DataBaseDto> getDataBase(Integer dataBaseId);
    
} 
