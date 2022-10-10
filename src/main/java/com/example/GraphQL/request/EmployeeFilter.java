package com.example.GraphQL.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFilter {
    private String name;
    private String address;
    private Integer age;
}
