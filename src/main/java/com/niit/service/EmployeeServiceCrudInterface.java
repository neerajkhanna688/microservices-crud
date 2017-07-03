package com.niit.service;



import com.niit.model.Employee;
import com.niit.util.EmployeeNotFound;

public interface EmployeeServiceCrudInterface {
	
	public Employee create(Employee employee);
    public Employee delete(int id) throws EmployeeNotFound;
    public Iterable<Employee> findAll();
    public Employee update(Employee shop) throws EmployeeNotFound;
    public Employee findById(int id);
    public Iterable<Employee> findByName(String name);

}
