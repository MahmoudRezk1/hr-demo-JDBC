package com.global.jdbchrdemo.repository;

import com.global.jdbchrdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepo {
    int count();
    Employee findById(Integer id);
    List<Employee> findAll();
    int insert(Employee employee);
    int update(Employee employee);

    int delete(Integer id);

}
