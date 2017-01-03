package springmvc.test;

import org.apache.log4j.Logger;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.spring.mvc.api.UserManager;
import com.spring.mvc.model.Role;
import com.spring.mvc.model.User;

public class UserTest extends BaseTest{
	
	@Mock
	private User user;
	
	
	private Logger logger = Logger.getLogger(UserTest.class);
	
	@Test
	public void addUser(){
		
		User user = new User();
		user.setName("anil");
		user.setLogin("true");
		user.setPassword("anil");
		
	}

}
