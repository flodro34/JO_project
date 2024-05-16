package com.fdr.jo_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fdr.jo_project")
public class JoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoProjectApplication.class, args);
    }

}
