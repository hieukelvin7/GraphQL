package com.example.GraphQL.impl;

import com.example.GraphQL.entities.Employee;
import com.example.GraphQL.repository.EmployeeRepository;
import com.example.GraphQL.request.EmployeeFilter;
import com.example.GraphQL.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

//    @Override
//    public Page<Employee> getAll(int page, int size, String sort) {
//        String[] arr = null;
//        arr = sort.split(",");
//        String first = arr[0];
//        Sort sortable = null;
//        if (arr[1].equals("ASC")) {
//            sortable = Sort.by(first).ascending();
//        }
//        if (arr[1].equals("DESC")) {
//            sortable = Sort.by(first).descending();
//        }
//        PageRequest pr = PageRequest.of(page, size,sortable);
//        return employeeRepository.findAll(pr);
//    }
@Override
public Page<Employee> getAll(String name,int page, int size, String sort) {

    Sort sortable = null;
    if (sort.equals("ASC")) {
        sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
    return employeeRepository.findByName(name, PageRequest.of(page, size, sortable));

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
