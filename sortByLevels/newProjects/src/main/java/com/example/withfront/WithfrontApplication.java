package com.example.withfront;

import com.example.withfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WithfrontApplication {
    @Autowired
    UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(WithfrontApplication.class, args);
    }

}
