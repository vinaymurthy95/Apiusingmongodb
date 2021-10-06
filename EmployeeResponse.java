package com.agiliz.springmongo.response;

import java.util.List;

import org.springframework.stereotype.Component;
import com.agiliz.springmongo.model.Employee;

@Component
public class EmployeeResponse {
	private boolean error;
	private String message;
	private int statusCode;
	private List<Employee> LiEmployees;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<Employee> getLiEmployees() {
		return LiEmployees;
	}

	public void setLiEmployees(List<Employee> liEmployees) {
		LiEmployees = liEmployees;
	}

}
