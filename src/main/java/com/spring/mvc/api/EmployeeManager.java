package com.spring.mvc.api;

import java.util.List;

import com.spring.mvc.model.Employee;

public interface EmployeeManager {
	
	void saveEmployee(Employee employee);
	List<Employee> findAllEmployees();
	void deleteEmployeeBySsn(String ssn);
}
