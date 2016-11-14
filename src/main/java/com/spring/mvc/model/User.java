package com.spring.mvc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    
    public User()
    {
    }
    public User(Integer id, String name, String address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public User(String name, String address)
    {
        this.name = name;
        this.address = address;
    }
    
    @Override
    public String toString()
    {
        return "User [address=" + address + ", id=" + id + ", name=" + name+ "]";
    }
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    
}