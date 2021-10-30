package com.empmangement.sample.service;

import org.springframework.data.repository.CrudRepository;

import com.empmangement.sample.model.Department;

public interface IDepartmentRepository extends CrudRepository<Department, Integer> {

}
