package com.empmangement.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmangement.sample.model.Department;

@Service
public class DepartmentService {

	@Autowired
	IDepartmentRepository repository;
	
	public List<Department> findAllDepartments(){
		List<Department> departments = new ArrayList<>();
		repository.findAll().forEach(dept -> departments.add(dept));
		return departments;
	}
}
