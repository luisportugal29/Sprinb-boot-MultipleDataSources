package com.coppel.demo.repositories.testing;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coppel.demo.entities.testing.CasoPrueba;

public interface CasoPruebaRepository extends CrudRepository<CasoPrueba, Integer> {

    List<CasoPrueba> findAll();
    
}
