//package com.example.sweater.config.multi;
//
//import com.example.sweater.domain.multi.User1;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//
//@EnableJpaRepositories(
//        basePackages = Data2.basePackages,
//        entityManagerFactoryRef =  Data2.entityManagerFactoryRef,
//        transactionManagerRef = Data2.transactionManagerRef)
//public class MultiUserConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix=Data2.configurationProperties)
//    public DataSource userDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = Data2.entityManagerFactoryRef)
//    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
//            EntityManagerFactoryBuilder builder) {
//
//        return builder
//                .dataSource(userDataSource())
//                .packages(User1.class)
//                .persistenceUnit(Data2.persistenceUnit)
//                .build();
//    }
//    @Bean(name = Data2.transactionManagerRef)
//    public PlatformTransactionManager secondTransactionManager(
//            @Qualifier(Data2.entityManagerFactoryRef) EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}