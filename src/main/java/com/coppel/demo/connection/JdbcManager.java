package com.coppel.demo.connection;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.coppel.demo.entities.testing.DataBase;
import com.coppel.demo.repositories.testing.DataBaseRepository;
import com.zaxxer.hikari.HikariDataSource;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class JdbcManager {

    private final DataBaseRepository dataBaseRepository;
    private final JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate(Integer databaseId) {
        DataBase dataBase = dataBaseRepository
        .findById(databaseId)
        .orElseThrow();

        HikariDataSource ddataSource = new HikariDataSource();
        HikariDataSource hikariDataSource = createDynamicDataSource(dataBase);
        jdbcTemplate.setDataSource(ddataSource);
        jdbcTemplate.setDataSource(hikariDataSource);
        return jdbcTemplate;
    }

    private HikariDataSource createDynamicDataSource(DataBase dataBase) {
        final String url = "jdbc:postgresql://%s:%s/%s"
        .formatted(dataBase.getIpAddress(), dataBase.getPortNumber(), dataBase.getName());
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("org.postgresql.Driver");
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(dataBase.getUserName());
        hikariDataSource.setPassword(dataBase.getPassword());

        return hikariDataSource;

    }

    
}
