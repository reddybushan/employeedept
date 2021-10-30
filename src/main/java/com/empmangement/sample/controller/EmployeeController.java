package com.empmangement.sample.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

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
	public String addEmployeeInfo(@RequestBody Employee employee) {
		logger.info("received employee object"+employee);
		
		Employee emp =employeService.saveorUpdateEmployee(employee);
		return "Employee Saved Sucessfully";
		
	}
	
	@PostMapping("/updateEmployee") 
	public String updateEmployeeInfo(@RequestBody Employee employee) {
		
		Employee emp =employeService.saveorUpdateEmployee(employee);
		return "Employee updated Sucessfully";
		
	}
	
	@PostMapping("/deleteEmployee/{employeeId}") 
	public String deleteEmployee(@PathVariable Integer employeeId) throws Exception {
		
		Optional<Employee> employee = Optional.ofNullable(employeService.findByEmployeeId(employeeId)).orElseThrow(() -> new Exception("employee not found"));
		employeService.deleteEmployee(employee.get());
		return "Employee deleted Sucessfully";
		
	}
	
	@GetMapping("/getAllEmployees") 
	public List<Employee> getEmployees() {
		
		List<Employee> emp =employeService.findAllEmployessInfo();
		return emp;
		
	}
}
