package com.spring.mvc.controller;



import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

	Logger logger = Logger.getLogger(UserController.class);
	
//	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String user(){
		logger.info("Workgin or not");
		return "ck";
	}
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greeting(){
		logger.info("fusding");
//		scheduleFixedRateTask();
		return "great";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public User addUser(@RequestBody User user){
		return this.userManager.addNew(user);
	}
	
//	@Scheduled(fixedRate = 1000)
//	public void scheduleFixedRateTask() {
//		logger.info("scheduler start");
//	}
	
	@Scheduled(cron="*/5 * * * * ?")
    public void demoServiceMethod()
    {
        System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
    }
	

}
