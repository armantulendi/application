 package com.example.withfront.config;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.boot.context.properties.ConfigurationProperties;
 import org.springframework.boot.jdbc.DataSourceBuilder;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.core.env.Environment;
 import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 import org.springframework.orm.jpa.JpaTransactionManager;
 import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
 import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
 import org.springframework.transaction.PlatformTransactionManager;
 import org.springframework.transaction.annotation.EnableTransactionManagement;

 import javax.persistence.EntityManagerFactory;
 import javax.sql.DataSource;
 import java.util.HashMap;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = Data2.basePackages,
        entityManagerFactoryRef =  Data2.entityManagerFactoryRef,
        transactionManagerRef = Data2.transactionManagerRef)
public class SubscriberConfig {
    @Autowired
    private Environment env;
    @Bean
    @ConfigurationProperties(prefix=Data2.configurationProperties)
    public DataSource subscriberDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = Data2.entityManagerFactoryRef)
    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em =
                new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(subscriberDataSource());
        em.setPersistenceUnitName(Data2.persistenceUnit);
        em.setPackagesToScan(Data2.scanPackages);
        final HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(name = Data2.transactionManagerRef)
    public PlatformTransactionManager firstTransactionManager(
            @Qualifier(Data2.entityManagerFactoryRef) EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager transactionManager =
                new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(firstEntityManagerFactory().getObject());
        return transactionManager;
    }
}