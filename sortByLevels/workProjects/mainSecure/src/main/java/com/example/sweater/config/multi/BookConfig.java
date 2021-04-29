//package com.example.sweater.config.multi;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.HashMap;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = Data1.basePackages,
//        entityManagerFactoryRef = Data1.entityManagerFactoryRef,
//        transactionManagerRef = Data1.transactionManagerRef)
//public class BookConfig {
//    private final Environment env;
//
//    public BookConfig(Environment env) {
//        this.env = env;
//    }
//
//    @Bean
//
//    @Primary
//    @ConfigurationProperties(prefix=Data1.configurationProperties)
//    public DataSource bookDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Primary
//    @Bean(name = Data1.entityManagerFactoryRef)
//    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory() {
//         LocalContainerEntityManagerFactoryBean em =
//                new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(bookDataSource());
//        em.setPersistenceUnitName(Data1.persistenceUnit);
//        em.setPackagesToScan(Data1.scanPackages);
//         HibernateJpaVendorAdapter vendorAdapter =
//                new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//         HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//                env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect",
//                env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//        return em;
//    }
//
//    @Primary
//    @Bean(name = Data1.transactionManagerRef)
//    public PlatformTransactionManager firstTransactionManager(
//            @Qualifier(Data1.entityManagerFactoryRef) EntityManagerFactory entityManagerFactory) {
//        final JpaTransactionManager transactionManager =
//                new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(firstEntityManagerFactory().getObject());
//        return transactionManager;
//    }
//}