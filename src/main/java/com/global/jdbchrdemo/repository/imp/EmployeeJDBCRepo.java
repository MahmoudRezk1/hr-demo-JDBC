package com.global.jdbchrdemo.repository.imp;

import com.global.jdbchrdemo.entity.Employee;
import com.global.jdbchrdemo.mapper.EmployeeMapper;
import com.global.jdbchrdemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
@Repository
@Qualifier(value ="employeeJDBCRepo")
public class EmployeeJDBCRepo implements EmployeeRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {

        return jdbcTemplate.queryForObject("select count(*) from employees;",Integer.class);
    }

    @Override
    public Employee findById(Integer id) {
        return jdbcTemplate.queryForObject("select id,name,salary from employees where id= ?",new Object[]{id},
                new EmployeeMapper());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select id,name,salary from employees",new EmployeeMapper());
    }

    @Override
    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into employees (id, name ,salary)values (?,?,?)",
                new Object[]{employee.getId(),employee.getName(),employee.getSalary()});
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("update employees set name=?,salary=?",new Object[]{employee.getName(),employee.getSalary()});
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("delete from employees where id=?",new Object[]{id});
    }
}
