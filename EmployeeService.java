package com.agiliz.springmongo.service;

import java.util.Optional;

import com.agiliz.springmongo.model.Employee;

public interface EmployeeService {

	Employee insert(Employee emp);

	Employee getrecord(int id);

	Employee update(int id, Employee emp);

	Employee delete(int id);

}
