package com.global.jdbchrdemo.config;

import com.global.jdbchrdemo.entity.Employee;
import com.global.jdbchrdemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StartupProject implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier(value ="employeeNamedParameterJDBCRepo")
    private EmployeeRepo employeeRepo;
    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("DROP Table if Exists employees");
        jdbcTemplate.execute("create table employees(id serial, name varchar(255)," +
                "salary numeric(15,2))");
        if (employeeRepo.count()==0) {
            employeeRepo.insert(new Employee(1, "mohamed", 1000.0));
            employeeRepo.insert(new Employee(2, "ahmed", 8000.0));
            employeeRepo.insert(new Employee(3, "mahmoud", 2200.0));
            employeeRepo.insert(new Employee(4, "samy", 2369.0));
        }
    }
}
