package com.example.GraphQL.controller;

import com.example.GraphQL.entities.Employee;
import com.example.GraphQL.repository.EmployeeRepository;
import com.example.GraphQL.services.EmployeeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class EmployeeController {

    private final EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }


    @MutationMapping("createEmployee")
    public Employee create (@Argument EmployeeInput employee){
        Employee emp = new Employee();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setAddress(employee.getAddress());
        emp.setAge(employee.getAge());
        return employeeService.create(emp);
    }
    @MutationMapping("updateEmployee")
    public Employee update (@Argument Long id ,@Argument EmployeeInput employee){
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setAddress(employee.getAddress());
        emp.setAge(employee.getAge());
        return employeeService.update(id,emp);
    }

    @QueryMapping("allEmployees")
    public List<Employee> getAll(){
        return employeeService.getAll();
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

@Getter
@Setter
class EmployeeInput{
    private String name;
    private String email;
    private String address;
    private Integer age;
}
