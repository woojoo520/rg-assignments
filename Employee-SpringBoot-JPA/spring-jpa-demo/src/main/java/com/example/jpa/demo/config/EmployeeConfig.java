package com.example.jpa.demo.config;

import com.example.jpa.demo.entity.Employee;
import com.example.jpa.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner (
            EmployeeRepository employeeRepository) {
        return args -> {
            Employee woojoo = new Employee(
                    "woojoo",
                    "HR"
            );
            Employee alex = new Employee(
                    "alex",
                    "EDM"
            );
            employeeRepository.saveAll(
                    List.of(woojoo, alex)
            );
        };
    }
}
