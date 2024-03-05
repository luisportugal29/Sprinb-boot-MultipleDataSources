package com.coppel.demo.entities.testing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cat_categoriascasosdeprueba")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoriaCasoPrueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idu_categoria")
    private Integer id;

    @Column(name = "nom_categoria")
    private String nombre;

    @Column(name = "des_categoria")
    private String descripcion;
    
}
