package com.niit.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustomInterface {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getEmployeeByName(String name) {
		return this.entityManager.
				createQuery("select e from Employee e where e.name like '"+name+"'").
					getResultList();
	}

}
