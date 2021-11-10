package com.example.managerstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class ManagerStudentApplication {


    public static void main(String[] args) {
        SpringApplication.run(ManagerStudentApplication.class, args);
    }
}
