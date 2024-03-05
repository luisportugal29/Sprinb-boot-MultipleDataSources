package com.coppel.demo.repositories.testing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coppel.demo.entities.testing.DataBase;

public interface DataBaseRepository extends JpaRepository<DataBase, Integer> {

    Optional<DataBase> findById(Integer id);
    
}
