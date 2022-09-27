package com.example.GraphQL.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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

    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
