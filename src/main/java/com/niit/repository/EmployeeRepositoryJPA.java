package com.niit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.model.Employee;

public interface EmployeeRepositoryJPA extends JpaRepository<Employee, Integer> {

}
