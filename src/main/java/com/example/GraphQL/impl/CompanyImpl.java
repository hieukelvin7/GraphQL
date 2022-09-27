package com.example.GraphQL.impl;

import com.example.GraphQL.entities.Company;
import com.example.GraphQL.entities.Employee;
import com.example.GraphQL.repository.CompanyRepository;
import com.example.GraphQL.services.ComapnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyImpl implements ComapnyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Employee> findCompanyId(Long id) {
        return companyRepository.findCompanyId(id);
    }

    @Override
    public Company update(long id, Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Boolean delete(long id) {
        companyRepository.deleteById(id);
        return true;
    }
}
