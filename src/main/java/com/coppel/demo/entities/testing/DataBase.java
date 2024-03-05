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
@Table(name = "database")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DataBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ipAddress;

    private String name;

    private String password;

    private String userName;

    private String portNumber;
    
}
