package com.example.withfront.config;
class Data1 {
     static final String basePackages="com.example.withfront.repo.book";
     static final String scanPackages="com.example.withfront";
     static final String entityManagerFactoryRef="bookEntityManager";
     static final String transactionManagerRef="bookTransactionManager";
     static final String persistenceUnit="bookUnit";
     static final String configurationProperties="spring.booking.datasource";
}
class  Data2 {
     static final String basePackages="com.example.withfront.repo.subscriber";
     static final String scanPackages="com.example.withfront";
     static final String entityManagerFactoryRef="subscriberEntityManager";
     static final String transactionManagerRef="subscriberTransactionManager";
     static final String configurationProperties="spring.subscriber.datasource";
     static final String persistenceUnit="subscriberUnit";
}
class  Data3 {
     static final String basePackages="com.example.withfront.repo.user";
     static final String entityManagerFactoryRef="userEntityManager";
     static final String transactionManagerRef="userTransactionManager";
     static final String configurationProperties="spring.user.datasource";
     static final String persistenceUnit="userUnit";
}
