package com.example.springbootconfigdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    Environment environment;

    @PostConstruct
    void init() {
        System.out.println(environment.getProperty("my-property"));
    }

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "config");
        System.setProperty("spring.config.location", "classpath:/application-default.properties,classpath:/application.properties");
        SpringApplication.run(Application.class, args);
    }
}
