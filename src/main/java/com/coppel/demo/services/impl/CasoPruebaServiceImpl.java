package com.coppel.demo.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coppel.demo.dtos.DataBaseDto;
import com.coppel.demo.entities.testing.CasoPrueba;
import com.coppel.demo.repositories.testing.BaseDatosRepository;
import com.coppel.demo.repositories.testing.CasoPruebaRepository;
import com.coppel.demo.services.ICasoPruebaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CasoPruebaServiceImpl implements ICasoPruebaService{

    private final CasoPruebaRepository casoPruebaRepository;
    private final BaseDatosRepository dataBaseRepository;

    @Override
    public List<CasoPrueba> getCasosDePrueba() {
        List<CasoPrueba> casos =  casoPruebaRepository.findAll();
        return casos;
    };

    @Override
    public List<DataBaseDto> getDataBase(Integer dataBaseId) {
       List<DataBaseDto> dataBases = dataBaseRepository.getDataBases(dataBaseId);
       return dataBases;
    }
    
}
