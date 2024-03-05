package com.coppel.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coppel.demo.entities.formula.Driver;
import com.coppel.demo.services.IDriverService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/drivers")
@AllArgsConstructor
public class DriversController {
    
    private final IDriverService driverService;

    @GetMapping
    public ResponseEntity<List<Driver>> getDrivers() {
        List<Driver> drivers = driverService.getDrivers();
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(drivers);
    }
}
