package com.example.multi.config;
class Data1 {
     static final String basePackages="com.example.multi.dao.book";
     static final String scanPackages="com.example.multi";
     static final String entityManagerFactoryRef="bookEntityManager";
     static final String transactionManagerRef="bookTransactionManager";
     static final String persistenceUnit="bookUnit";
     static final String configurationProperties="spring.booking.datasource";
}
class  Data2 {
     static final String basePackages="com.example.multi.dao.user";
     static final String entityManagerFactoryRef="userEntityManager";
     static final String transactionManagerRef="userTransactionManager";
     static final String configurationProperties="spring.user.datasource";
     static final String persistenceUnit="userUnit";
}
class  Data3 {
     static final String basePackages="com.example.multi.dao.data";
     static final String entityManagerFactoryRef="dataEntityManager";
     static final String transactionManagerRef="dataTransactionManager";
     static final String configurationProperties="spring.data.datasource";
     static final String persistenceUnit="dataUnit";
}
