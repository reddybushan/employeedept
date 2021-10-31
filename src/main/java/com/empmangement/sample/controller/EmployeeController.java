package com.empmangement.sample.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmangement.sample.model.Employee;
import com.empmangement.sample.service.EmployeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeService employeService;
	Logger logger = Logger.getLogger(EmployeeController.class);
	
	
	@GetMapping("/hello") 
	public String showDisplayMessage() {
		
		return "hellow world";
	}
	
	@PostMapping("/addEmployee")
	@CrossOrigin(origins = "http://localhost:4200")
	public String addEmployeeInfo(@RequestBody Employee employee) {
		logger.info("received employee object"+employee);
		
		Employee emp =employeService.saveorUpdateEmployee(employee);
		return "Employee Saved Sucessfully";
		
	}
	
	@PutMapping("/updateEmployee/{id}") 
	@CrossOrigin(origins = "http://localhost:4200")
	public String updateEmployeeInfo(@PathVariable Integer id,@RequestBody Employee employee) {
		logger.info("received employee object"+employee);
		
		employee.setEmployeeId(id);
		
		Employee emp =employeService.saveorUpdateEmployee(employee);
		return "Employee updated Sucessfully";
		
	}
	
	@DeleteMapping("/deleteEmployee/{employeeId}") 
	
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteEmployee(@PathVariable Integer employeeId) throws Exception {
		
		Optional<Employee> employee = Optional.ofNullable(employeService.findByEmployeeId(employeeId)).orElseThrow(() -> new Exception("employee not found"));
		employeService.deleteEmployee(employee.get());
		return "Employee deleted Sucessfully";
		
	}
	
	@GetMapping("/getAllEmployees") 
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> getEmployees() {
		
		List<Employee> emp =employeService.findAllEmployessInfo();
		return emp;
		
	}
	
	@GetMapping("/getEmployee/{id}") 
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee getEmployeesInfo(@PathVariable Integer id) {
		Optional<Employee> employee = employeService.findByEmployeeId(id);

		return employee.isPresent() ? employee.get() : new Employee();
		
	}
}
