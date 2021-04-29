package com.example.withfront.config;

import com.example.withfront.model.Book;
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
        basePackages = Data1.basePackages,
        entityManagerFactoryRef = Data1.entityManagerFactoryRef,
        transactionManagerRef = Data1.transactionManagerRef)
public class BookConfig {
    @Bean
    @ConfigurationProperties(prefix=Data1.configurationProperties)
    public DataSource bookDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = Data1.entityManagerFactoryRef)
    public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {

        return builder
                .dataSource(bookDataSource())
                .packages(Book.class)
                .persistenceUnit(Data1.persistenceUnit)
                .build();
    }

    @Bean(name = Data1.transactionManagerRef)
    public PlatformTransactionManager firstTransactionManager(
            @Qualifier(Data1.entityManagerFactoryRef) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}