package com.niit.config;



import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.model.Employee;
import com.niit.service.EmployeeServiceCrudInterface;
import com.niit.service.EmployeeServiceJPAInterface;

public class AppConfigTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext("com.niit");
		EmployeeServiceJPAInterface ds = (EmployeeServiceJPAInterface )acac.getBean(EmployeeServiceJPAInterface.class);
		Employee e = ds.findById(1);
		System.out.println(" id : "+e.getID());
		System.out.println(" name : "+e.getName());
		
		EmployeeServiceCrudInterface empCrud = (EmployeeServiceCrudInterface)acac.getBean(EmployeeServiceCrudInterface.class);
		Employee eCrud = empCrud.findById(2);
		System.out.println(" id : "+eCrud.getID());
		System.out.println(" name : "+eCrud.getName());
		
		
	}

}
