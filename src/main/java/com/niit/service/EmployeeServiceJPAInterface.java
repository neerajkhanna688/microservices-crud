package com.niit.service;

import java.util.List;

import com.niit.model.Employee;
import com.niit.util.EmployeeNotFound;

public interface EmployeeServiceJPAInterface {
	public Employee create(Employee employee);
    public Employee delete(int id) throws EmployeeNotFound;
    public List<Employee> findAll();
    public Employee update(Employee shop) throws EmployeeNotFound;
    public Employee findById(int id);
}
