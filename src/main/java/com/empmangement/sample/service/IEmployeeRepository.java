package com.empmangement.sample.service;

import org.springframework.data.repository.CrudRepository;

import com.empmangement.sample.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer>{

}
