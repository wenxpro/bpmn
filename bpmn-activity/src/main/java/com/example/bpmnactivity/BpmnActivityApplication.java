package com.example.bpmnactivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude={org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class BpmnActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BpmnActivityApplication.class, args);
    }

}
