package springmvc.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.spring.mvc.api.UserManager;
import com.spring.mvc.model.User;

public class UserTest extends BaseTest{
	
	@Autowired 
	private UserManager userManager;
	
	private Logger logger = LoggerFactory.getLogger(UserTest.class);
	
	@Test
	public void addUser(){
		
//		User user = new User("name","address");
//		logger.info("USER :: " + user.getAddress());
//		user = this.userManager.addNew(user);
//		logger.info("Username is :: " + user.getName());
//		Assert.assertNotNull(user);
		
	}

}
