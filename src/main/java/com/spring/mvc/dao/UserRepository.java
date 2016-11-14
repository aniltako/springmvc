package com.spring.mvc.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.model.User;


public interface UserRepository extends CrudRepository<User, Long>{

  
}
