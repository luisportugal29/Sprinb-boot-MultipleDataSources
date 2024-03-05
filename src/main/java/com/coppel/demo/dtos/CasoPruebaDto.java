package com.coppel.demo.dtos;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CasoPruebaDto {

    private String nombre;

    private String descripcion;

    private Integer idCategoria;

    private List<Map<String, Object>> data;
    
}
