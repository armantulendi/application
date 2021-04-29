package com.example.multi.config;

import com.example.multi.model.Data;
import com.example.multi.model.User;
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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement

@EnableJpaRepositories(
        basePackages = Data3.basePackages,
        entityManagerFactoryRef =  Data3.entityManagerFactoryRef,
        transactionManagerRef = Data3.transactionManagerRef)
public class Example {

    @Bean
    @ConfigurationProperties(prefix=Data3.configurationProperties)
    public DataSource dataDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = Data3.entityManagerFactoryRef)
    public LocalContainerEntityManagerFactoryBean dataEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {

        return builder
                .dataSource(dataDataSource())
                .packages(Data.class)
                .persistenceUnit(Data3.persistenceUnit)
                .build();
    }
    @Bean(name = Data3.transactionManagerRef)
    public PlatformTransactionManager dataTransactionManager(
            @Qualifier(Data3.entityManagerFactoryRef) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}