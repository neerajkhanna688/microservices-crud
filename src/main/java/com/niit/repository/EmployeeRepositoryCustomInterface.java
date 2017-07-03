package com.niit.repository;

import java.util.List;

import com.niit.model.Employee;

public interface EmployeeRepositoryCustomInterface {

	public List<Employee> getEmployeeByName(String name);
}
