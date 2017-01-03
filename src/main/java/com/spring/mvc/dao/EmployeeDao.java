package com.spring.mvc.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.model.Employee;

@Transactional
public interface EmployeeDao extends JpaRepository<Employee, Long>{
//	void saveEmployee(Employee employee);
//	List<Employee> findAllEmployee();
	
	@Query(value="delete from employee where snn=?1",nativeQuery=true)
	void deleteEmployeeBySsn(String ssn);
}
