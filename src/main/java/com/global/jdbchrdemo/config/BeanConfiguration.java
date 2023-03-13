package com.global.jdbchrdemo.config;

import com.global.jdbchrdemo.repository.imp.EmployeeJDBCRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public EmployeeJDBCRepo getEmployeeJDBCRepo(){
        return new EmployeeJDBCRepo();
    }
}
