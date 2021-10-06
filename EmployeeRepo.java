package com.agiliz.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agiliz.springmongo.model.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer> {

}
