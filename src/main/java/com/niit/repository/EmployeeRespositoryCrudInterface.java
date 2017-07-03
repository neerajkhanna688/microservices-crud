package com.niit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niit.model.Employee;

@Repository
public interface EmployeeRespositoryCrudInterface extends CrudRepository<Employee, Integer>, EmployeeRepositoryCustomInterface{


}
