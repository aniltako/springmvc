package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.log4testng.Logger;

import com.spring.mvc.api.EmployeeManager;
import com.spring.mvc.dao.EmployeeDao;
import com.spring.mvc.model.Employee;

public class EmployeeManagerImpl implements EmployeeManager{

	@Autowired
	private EmployeeDao dao;
	
	Logger logger = Logger.getLogger(EmployeeManagerImpl.class);
	
	@Override
	public void saveEmployee(Employee employee) {
		List<Employee> employees = (List<Employee>) dao.findAll();
		for ( Employee e : employees ){
			if(e.getName().equals(employee.getName())){
				throw new RuntimeException("Employee already exists");
			}
		}
		logger.info("Saving Employee.... saved employee");
		dao.save(employee);
//		dao.saveEmployee(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return (List<Employee>) dao.findAll();
//		return dao.findAllEmployee();
	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		boolean found = false;
		List<Employee> employees = dao.findAll();
		for ( Employee e: employees ){
			if(e.getSsn().equals(ssn)){
				found = true;
				logger.info("Deleting employee by SSN..... deleted");
				return;
			}
		}
		if( !found ){
			throw new RuntimeException("Employee not found with this SSN");
			
		}
		dao.deleteEmployeeBySsn(ssn);
	}
	
	public String test(){
		
		Employee employee = getEmployee("anil");
		
		return employee.getName();
	}
	
	public Employee getEmployee(String name){
		return new Employee();
	}

}
