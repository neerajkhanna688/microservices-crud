package com.niit.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Employee;
import com.niit.repository.EmployeeRepositoryJPA;
import com.niit.repository.EmployeeRepositoryImpl;
import com.niit.repository.EmployeeRespositoryCrudInterface;
import com.niit.util.EmployeeNotFound;

@Service
public class EmployeeServiceCrudImpl implements EmployeeServiceCrudInterface {

	@Resource
	EmployeeRespositoryCrudInterface employeeRespositoryCrud;
    
	@Resource
	EmployeeRepositoryImpl employeeRepositoryImpl;
	
	@Override
	@Transactional
	public Employee create(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRespositoryCrud.save(employee);
	}

	@Override
	@Transactional(rollbackFor=EmployeeNotFound.class)
	public Employee delete(int id) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		Employee deletedEmployee = employeeRespositoryCrud.findOne(id);
         
	        if (deletedEmployee == null)
	            throw new EmployeeNotFound();
	        employeeRespositoryCrud.delete(id);
		 return deletedEmployee;
	}

	@Override
	@Transactional
	public Iterable<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRespositoryCrud.findAll();
	}

	@Override
	@Transactional(rollbackFor=EmployeeNotFound.class)
	public Employee update(Employee employee) throws EmployeeNotFound {
		Employee updatedEmployee = employeeRespositoryCrud.findOne(employee.getID());
        
        if (updatedEmployee == null)
            throw new EmployeeNotFound();
		
        updatedEmployee.setName(employee.getName());
        
        return updatedEmployee;
		
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeRespositoryCrud.findOne(id);
	}

	@Override
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepositoryImpl.getEmployeeByName(name);
	}

	
}
