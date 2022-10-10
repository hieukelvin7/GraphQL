package com.example.GraphQL.services;

import com.example.GraphQL.entities.Employee;
import com.example.GraphQL.request.EmployeeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;


import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    Page<Employee> getAll(String name,int page, int size, String sort);

    Employee get(long id);

    Employee update(long id, Employee employee);

    Boolean delete(long id);
}
