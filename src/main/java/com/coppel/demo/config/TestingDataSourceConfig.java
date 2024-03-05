package com.coppel.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "testingEntityManagerFactory",
    transactionManagerRef = "testingTransactionManager",
    basePackages = {"com.coppel.demo.repositories.testing"}
)
public class TestingDataSourceConfig {

    @Bean(name = "testingDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.testing")
    public DataSource testingDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "testingEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean testingEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("testingDataSource") DataSource dataSource
    ) {
        return builder
        .dataSource(dataSource)
        .packages("com.coppel.demo.entities.testing")
        .build();
    }

    @Bean(name = "testingTransactionManager")
    public PlatformTransactionManager testingTransactionManager(
        @Qualifier("testingEntityManagerFactory") EntityManagerFactory testingEntityManagerFactory
    ) {
        return new JpaTransactionManager(testingEntityManagerFactory);
    }
    
}
