package com.example.GraphQL.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String email;
    private String address;
    private Integer age;

}
