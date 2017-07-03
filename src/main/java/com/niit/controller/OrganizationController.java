package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.model.Employee;
import com.niit.service.EmployeeServiceCrudInterface;

@RestController
public class OrganizationController {
	
	@Autowired
	private EmployeeServiceCrudInterface employeeServiceCrudInterface ;
	
	@RequestMapping(value="/users/", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Employee>> getEmployee(){
		return new ResponseEntity<Iterable<Employee>>(employeeServiceCrudInterface.findAll(), HttpStatus.OK);
	}
	

}
