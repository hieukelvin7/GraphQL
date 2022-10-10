package com.example.GraphQL;

import com.example.GraphQL.entities.Company;
import com.example.GraphQL.entities.Employee;
import com.example.GraphQL.services.ComapnyService;
import com.example.GraphQL.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class GraphQlApplication implements CommandLineRunner {


	private final EmployeeService employeeService;
	private ComapnyService comapnyService;

	@Autowired
	public GraphQlApplication(EmployeeService employeeService, ComapnyService comapnyService) {
		this.employeeService = employeeService;
		this.comapnyService = comapnyService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Company c1 = new Company();
		c1.setName("dxc");
		Company c2 = new Company();
		c2.setName("fpt");

		comapnyService.create(c1);
		comapnyService.create(c2);

		Employee e1 = new Employee();
		e1.setName("hieu");
		e1.setEmail("hieu@gmail.com");
		e1.setAddress("hcm");
		e1.setAge(22);
		e1.setCompany(c1);
		Employee e3 = new Employee();
		e3.setName("hoa");
		e3.setEmail("hoa@gmail.com");
		e3.setAddress("hcm");
		e3.setAge(22);
		e3.setCompany(c1);
		Employee e4 = new Employee();
		e4.setName("hai");
		e4.setEmail("hai@gmail.com");
		e4.setAddress("hcm");
		e4.setAge(22);
		e4.setCompany(c1);
		Employee e2 = new Employee();
		e2.setName("admin");
		e2.setEmail("admin@gmail.com");
		e2.setAddress("hanoi");
		e2.setAge(30);
		e2.setCompany(c2);
		employeeService.create(e1);
		employeeService.create(e2);
		employeeService.create(e3);
		employeeService.create(e4);


	}
}
