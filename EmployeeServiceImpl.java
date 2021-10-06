package com.agiliz.springmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agiliz.springmongo.model.Employee;
import com.agiliz.springmongo.repository.EmployeeRepo;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee insert(Employee emp) {
		List<Employee> list = repo.findAll();
		if (list.contains(emp)) {
			return null;
		} else {
			return repo.save(emp);
		}
	}

	@Override
	public Employee getrecord(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Employee update(int id, Employee emp) {
		Employee updatepr = repo.findById(id).orElse(null);
		if (updatepr != null) {
			updatepr.setName(emp.getName());
			updatepr.setSalary(emp.getSalary());

			return repo.save(updatepr);
		}
		return null;
	}

	@Override
	public Employee delete(int id) {

		Employee deletepr = repo.findById(id).orElse(null);
		if (deletepr != null) {
			repo.delete(deletepr);
			return deletepr;
		}
		return null;
	}
}
