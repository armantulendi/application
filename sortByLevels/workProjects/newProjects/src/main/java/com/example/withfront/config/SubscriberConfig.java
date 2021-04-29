 package com.example.withfront.config;

 import com.example.withfront.model.Subscriber;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.boot.context.properties.ConfigurationProperties;
 import org.springframework.boot.jdbc.DataSourceBuilder;
 import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.core.env.Environment;
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
    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(
        EntityManagerFactoryBuilder builder) {
            return builder
                    .dataSource(subscriberDataSource())
                    .packages(Subscriber.class)
                    .persistenceUnit(Data2.persistenceUnit)
                    .build();
    }

    @Bean(name = Data2.transactionManagerRef)
    public PlatformTransactionManager thirstTransactionManager(
            @Qualifier(Data2.entityManagerFactoryRef) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
