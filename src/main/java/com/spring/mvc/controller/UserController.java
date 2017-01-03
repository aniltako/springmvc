package com.spring.mvc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.api.UserManager;
import com.spring.mvc.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserManager userManager;

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String user(){
		logger.info("Workgin or not");
		return "ck";
	}
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greeting(){
		logger.info("fusding");
		return "great";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public User addUser(@RequestBody User user){
		return this.userManager.addNew(user);
	}
	

}
