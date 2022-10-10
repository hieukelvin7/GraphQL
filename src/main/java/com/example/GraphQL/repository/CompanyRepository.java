package com.example.GraphQL.repository;

import com.example.GraphQL.entities.Company;
import com.example.GraphQL.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
//    @Query("SELECT e FROM Company c ,Employee e where c.id = e.company.id and c.id= :id")
//    Company findCompanyId(@Param("id") Long id);
    @Query("SELECT c FROM Company c  where c.id= :id")
    Company findCompanyId(@Param("id") Long id);



}
