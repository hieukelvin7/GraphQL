package com.example.GraphQL;

import com.example.GraphQL.entities.Employee;
import com.example.GraphQL.repository.EmployeeRepository;
import com.example.GraphQL.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQlApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee e1 = new Employee();
		e1.setName("hieu");
		e1.setEmail("hieu@gmail.com");
		e1.setAddress("hcm");
		e1.setAge(22);
		Employee e2 = new Employee();
		e2.setName("admin");
		e2.setEmail("admin@gmail.com");
		e2.setAddress("hanoi");
		e2.setAge(30);
		employeeService.create(e1);
		employeeService.create(e2);
	}
}
