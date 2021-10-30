package com.empmangement.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.empmangement.sample.model.Department;
import com.empmangement.sample.model.Employee;
import com.empmangement.sample.service.EmployeService;
import com.empmangement.sample.service.IDepartmentRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

	@Autowired
	IDepartmentRepository repository;
	
	@Autowired
	EmployeService empService;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
	
	public void run(String...args) throws Exception {

        Department department = new Department(1, "Soft", 1);
        repository.save(department);
        
        Employee emp = new Employee();
        emp.setEmployeeId(1);
        emp.setEmail("manager@mager.com");
        emp.setFirstName("manager");
        emp.setSalary(50000.50);

       
        // associate the objects
        empService.saveorUpdateEmployee(emp);

       
    }

}
