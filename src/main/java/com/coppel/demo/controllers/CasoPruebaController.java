package com.coppel.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coppel.demo.dtos.CasoPruebaDto;
import com.coppel.demo.dtos.DataBaseDto;
import com.coppel.demo.entities.testing.CasoPrueba;
import com.coppel.demo.services.ICasoPruebaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/casos-prueba")
@AllArgsConstructor
public class CasoPruebaController {

    private final ICasoPruebaService casoPruebaService;

    @GetMapping
    public ResponseEntity<List<CasoPrueba>> getCasosPrueba() {
        List<CasoPrueba> casosDePruebas = casoPruebaService.getCasosDePrueba();
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(casosDePruebas);
    }

    @GetMapping("/database/{id}")
    public ResponseEntity<List<DataBaseDto>> testUseCase(
        @PathVariable Integer id
    ) {
       List<DataBaseDto> dataBases = casoPruebaService.getDataBase(id);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(dataBases);
    }
    
}
