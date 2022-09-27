package com.example.GraphQL.services;

import com.example.GraphQL.entities.Company;
import com.example.GraphQL.entities.Employee;

import java.util.List;

public interface ComapnyService {
    Company create(Company company);
    List<Company> getAll();

    List<Employee> findCompanyId(Long id);
    Company update(long id, Company company);

    Boolean delete(long id);
}
