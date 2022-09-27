package com.example.GraphQL.controller;

import com.example.GraphQL.entities.Company;
import com.example.GraphQL.entities.Employee;
import com.example.GraphQL.request.CompanyInput;
import com.example.GraphQL.services.ComapnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class CompanyController  {
    private final ComapnyService comapnyService;

    @Autowired
    public CompanyController(ComapnyService comapnyService) {
        this.comapnyService = comapnyService;
    }


    @MutationMapping("createCompany")
    public Company create (@Argument CompanyInput company){
        Company c = new Company();
        c.setName(company.getName());
        return comapnyService.create(c);
    }
    @MutationMapping("updateCompany")
    public Company update (@Argument Long id ,@Argument CompanyInput company){
        Company c = new Company();
        c.setId(id);
        c.setName(company.getName());
        return comapnyService.update(id,c);
    }
    @MutationMapping("deleteCompany")
    public Boolean delete (@Argument long id){
        return comapnyService.delete(id);
    }

    @QueryMapping("allCompany")
    public List<Company> getAll (){
        return comapnyService.getAll();
    }

    @QueryMapping("getCompany")
    public Company get (@Argument Long id){
        return comapnyService.findCompanyId(id);
    }


}

