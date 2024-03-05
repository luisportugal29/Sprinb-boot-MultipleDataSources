package com.coppel.demo.repositories.formula;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coppel.demo.entities.formula.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    List<Driver> findAll();

    Optional<Driver> findById(Integer id);
    
}
