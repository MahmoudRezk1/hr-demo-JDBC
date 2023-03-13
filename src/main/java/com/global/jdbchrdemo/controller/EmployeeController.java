package com.global.jdbchrdemo.controller;

import com.global.jdbchrdemo.entity.Employee;
import com.global.jdbchrdemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    @Qualifier(value = "employeeNamedParameterJDBCRepo")
    private EmployeeRepo employeeRepo;

    @GetMapping("/count")
    public int countEmployees(){
        return employeeRepo.count();
    }
    @GetMapping("/{id}")
    public Employee finById(@PathVariable Integer id){
        return this.employeeRepo.findById(id);
    }
    @GetMapping("")
    public List<Employee> finAll(){
        return this.employeeRepo.findAll();
    }
}
