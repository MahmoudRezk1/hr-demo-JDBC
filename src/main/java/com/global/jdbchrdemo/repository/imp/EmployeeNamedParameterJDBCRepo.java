package com.global.jdbchrdemo.repository.imp;

import com.global.jdbchrdemo.entity.Employee;
import com.global.jdbchrdemo.mapper.EmployeeMapper;
import com.global.jdbchrdemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier(value = "employeeNamedParameterJDBCRepo")
public class EmployeeNamedParameterJDBCRepo implements EmployeeRepo {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int count() {

//        return namedParameterJdbcTemplate.queryForObject("select count(*) from employees;",Integer.class);
        return 0;
    }

    @Override
    public Employee findById(Integer id) {
        return namedParameterJdbcTemplate.queryForObject("select id,name,salary from employees where id=:id",
                new MapSqlParameterSource("id",id),
                new EmployeeMapper());
    }

    @Override
    public List<Employee> findAll() {
        return namedParameterJdbcTemplate.query("select id,name,salary from employees",new EmployeeMapper());
    }

    @Override
    public int insert(Employee employee) {
        return namedParameterJdbcTemplate.update("insert into employees (id, name ,salary)values (:id,:name,:salary)",new BeanPropertySqlParameterSource(employee));

    }

    @Override
    public int update(Employee employee) {
        return namedParameterJdbcTemplate.update("update employees set name=:name,salary=:salary",new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public int delete(Integer id) {
        return namedParameterJdbcTemplate.update("delete from employees where id=:id",new MapSqlParameterSource("id",id));
    }
}
