package com.example.GraphQL.impl;

import com.example.GraphQL.entities.Employee;
import com.example.GraphQL.repository.EmployeeRepository;
import com.example.GraphQL.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee get(long id) {
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Not found employee"));
    }

    @Override
    public Employee update(long id, Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Boolean delete(long id) {
        employeeRepository.deleteById(id);
        return true;
    }
}
