package com.agiliz.springmongo.controller;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agiliz.springmongo.model.Employee;
import com.agiliz.springmongo.repository.EmployeeRepo;
import com.agiliz.springmongo.response.EmployeeResponse;
import com.agiliz.springmongo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeResponse resp;

	@Autowired
	private EmployeeService service;

	@PostMapping("/add")
	public ResponseEntity<EmployeeResponse> insertproduct(@RequestBody Employee emp) {
		Employee insertemp = service.insert(emp);
		if (insertemp != null) {
			resp.setError(false);
			resp.setMessage("data saved successfully");
			resp.setStatusCode(200);
			resp.setLiEmployees(Arrays.asList(insertemp));
			return new ResponseEntity<>(resp, HttpStatus.OK);

		} else {

			resp.setError(true);
			resp.setMessage("data allready exist you can not add duplicate");
			resp.setStatusCode(404);
			resp.setLiEmployees(null);
			return new ResponseEntity<EmployeeResponse>(resp, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/getByID/{id}")
	public ResponseEntity<EmployeeResponse> getrecord(@PathVariable("id") int id) {
		Employee getemp = service.getrecord(id);
		if (getemp != null) {
			resp.setError(false);
			resp.setMessage("data fetch successfully");
			resp.setStatusCode(200);
			resp.setLiEmployees(Arrays.asList(getemp));
			return new ResponseEntity<EmployeeResponse>(resp, HttpStatus.OK);

		} else {

			resp.setError(true);
			resp.setMessage("data not found");
			resp.setStatusCode(404);
			resp.setLiEmployees(null);
			return new ResponseEntity<EmployeeResponse>(resp, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeResponse> update(@PathVariable("id") int id, @RequestBody Employee emp) {
		Employee updateemp = service.update(id, emp);
		if (updateemp != null) {
			resp.setError(false);
			resp.setMessage("data updated successfully");
			resp.setStatusCode(200);
			resp.setLiEmployees(Arrays.asList(updateemp));
			return new ResponseEntity<>(resp, HttpStatus.OK);

		} else {

			resp.setError(true);
			resp.setMessage("data not found");
			resp.setStatusCode(404);
			resp.setLiEmployees(null);
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteByID/{id}")
	public ResponseEntity<EmployeeResponse> delete(@PathVariable("id") int id) {
		Employee deleteemp = service.delete(id);
		if (deleteemp != null) {
			resp.setError(false);
			resp.setMessage("data deleted successfully");
			resp.setStatusCode(200);
			resp.setLiEmployees(Arrays.asList(deleteemp));
			return new ResponseEntity<>(resp, HttpStatus.OK);

		} else {

			resp.setError(true);
			resp.setMessage("data not found");
			resp.setStatusCode(404);
			resp.setLiEmployees(null);
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
	}
}
