package com.example.GraphQL.services;

import com.example.GraphQL.entities.Employee;


import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    List<Employee> getAll();
    Employee get(long id);

    Employee update(long id, Employee employee);

    Boolean delete(long id);
}
