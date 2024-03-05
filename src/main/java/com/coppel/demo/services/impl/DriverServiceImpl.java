package com.coppel.demo.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coppel.demo.entities.formula.Driver;
import com.coppel.demo.repositories.formula.DriverRepository;
import com.coppel.demo.services.IDriverService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements IDriverService {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }
    
    
}
