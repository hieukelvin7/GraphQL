package com.example.GraphQL.repository;

import com.example.GraphQL.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Query("SELECT u FROM Employee u WHERE u.name LIKE CONCAT('%',:name,'%')")
    Page<Employee> findByName(String name, Pageable pageable);

}
