package com.coppel.demo.entities.testing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cat_casosdeprueba")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CasoPrueba {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idu_casoprueba")
    private Integer id;

    @Column(name = "nom_casoprueba")
    private String nombre;

    @Column(name = "des_casoprueba")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idu_categoria")
    private CategoriaCasoPrueba categoria;
    
}
