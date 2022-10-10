package com.example.GraphQL.controller;

import com.example.GraphQL.entities.Company;
import com.example.GraphQL.entities.Employee;
import com.example.GraphQL.repository.CompanyRepository;
import com.example.GraphQL.request.EmployeeInput;
import com.example.GraphQL.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyRepository companyRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CompanyRepository companyRepository) {
        this.employeeService = employeeService;
        this.companyRepository = companyRepository;
    }


    @MutationMapping("createEmployee")
    public Employee create (@Argument EmployeeInput employee){
        Company company = companyRepository.findById(employee.getCompanyId()).get();

        Employee emp = new Employee();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setAddress(employee.getAddress());
        emp.setAge(employee.getAge());
        emp.setCompany(company);
        return employeeService.create(emp);
    }
    @MutationMapping("updateEmployee")
    public Employee update (@Argument Long id ,@Argument EmployeeInput employee){
        Company company = companyRepository.findById(employee.getCompanyId()).get();
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setAddress(employee.getAddress());
        emp.setAge(employee.getAge());
        emp.setCompany(company);
        return employeeService.update(id,emp);
    }

//    @QueryMapping("allEmployees")
//    public List<Employee> getAll(){
//        return employeeService.getAll();
//    }
    @QueryMapping("allEmployeePaged")
    public Page<Employee> allEmployeePaged(@Argument String name,@Argument int page,@Argument int size, @Argument String sort){
        return employeeService.getAll(name,page,size, sort);
    }



    @QueryMapping("getEmployee")
    public Employee get(@Argument int id){
        return employeeService.get(id);
    }

    @MutationMapping("deleteEmployee")
    public Boolean delete (@Argument long id){
        return employeeService.delete(id);
    }
}


