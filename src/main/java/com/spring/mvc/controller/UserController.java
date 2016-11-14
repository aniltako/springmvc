package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.api.UserManager;
import com.spring.mvc.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserManager userManager;
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public User addUser(@RequestBody User user){
		return this.userManager.addNew(user);
	}

}
