package com.niit.service;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Employee;
import com.niit.repository.EmployeeRepositoryJPA;
import com.niit.util.EmployeeNotFound;

@Service
public class EmployeeServiceJPAImpl implements EmployeeServiceJPAInterface {

	@Resource
	EmployeeRepositoryJPA employeeRepository;
	
	@Override
	@Transactional
	public Employee create(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional(rollbackFor=EmployeeNotFound.class)
	public Employee delete(int id) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		Employee deletedEmployee = employeeRepository.findOne(id);
         
	        if (deletedEmployee == null)
	            throw new EmployeeNotFound();
		 employeeRepository.delete(id);
		 return deletedEmployee;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=EmployeeNotFound.class)
	public Employee update(Employee employee) throws EmployeeNotFound {
		Employee updatedEmployee = employeeRepository.findOne(employee.getID());
        
        if (updatedEmployee == null)
            throw new EmployeeNotFound();
		
        updatedEmployee.setName(employee.getName());
        
        return updatedEmployee;
		
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(id);
	}

}
