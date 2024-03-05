package com.coppel.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "formulaEntityManagerFactory",
    transactionManagerRef = "formulaTransactionManager",
    basePackages = {"com.coppel.demo.repositories.formula"}
)
public class FormulaDataSourceConfig {
    
    @Bean(name = "formulaDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.formula")
    public DataSource formulaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "formulaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean formulaEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("formulaDataSource") DataSource dataSource
    ) { 
        return builder
        .dataSource(dataSource)
        .packages("com.coppel.demo.entities.formula")
        .build();
    }

    @Bean(name = "formulaTransactionManager")
    public PlatformTransactionManager formulaTransactionManager(
        @Qualifier("formulaEntityManagerFactory") EntityManagerFactory formulaEntityManagerFactory
    ) {
        return new JpaTransactionManager(formulaEntityManagerFactory);
    }


}
