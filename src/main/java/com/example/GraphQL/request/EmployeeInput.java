package com.example.GraphQL.request;

import com.example.GraphQL.entities.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeInput {
    private String name;
    private String email;
    private String address;
    private Integer age;
    private Long companyId;
}
