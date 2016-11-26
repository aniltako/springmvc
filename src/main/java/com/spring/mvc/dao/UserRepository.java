package com.spring.mvc.dao;


import org.springframework.data.repository.CrudRepository;

import com.spring.mvc.model.User;


public interface UserRepository extends CrudRepository<User, Long>{
	User findByLogin(String login);
  
}
