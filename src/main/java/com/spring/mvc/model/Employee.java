package com.spring.mvc.model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "employee")
public class Employee {
 
    private Integer id;
 
    private String name;
 
    private BigDecimal salary;
 
    private String ssn;
 
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
	@Column(name = "name")
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
  
	@Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }
 
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
	@Column(name = "ssn")
    public String getSsn() {
        return ssn;
    }
 
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
 
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", ssn=" + ssn + "]";
    }
 
}