package com.empmangement.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmangement.sample.model.Employee;

@Service
public class EmployeService {

	@Autowired
	IEmployeeRepository employeeRepository;

	public Employee saveorUpdateEmployee(Employee employee) {

		Employee e = employeeRepository.save(employee);

		return e;

	}

	public Employee deleteEmployee(Employee employee) {

		employeeRepository.delete(employee);
		return employee;

	}

	public Optional<Employee> findByEmployeeId(Integer id) {
		return employeeRepository.findById(id);
	}
	
	public List<Employee> findAllEmployessInfo() {
		List<Employee> employeeInfo = new ArrayList<>();
		 employeeRepository.findAll().forEach(e -> employeeInfo.add(e));
		
		 return employeeInfo;
	}
	
	
}
