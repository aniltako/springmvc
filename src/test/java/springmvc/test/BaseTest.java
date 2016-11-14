package springmvc.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.spring.mvc.config.AppConfig;
import com.spring.mvc.config.AppInitializer;
import com.spring.mvc.config.MysqlDbConfig;

@ContextConfiguration(classes={AppConfig.class, AppInitializer.class, MysqlDbConfig.class})
@WebAppConfiguration
public class BaseTest extends AbstractTransactionalTestNGSpringContextTests{
	
	@BeforeSuite
	public void before(){
		System.out.println("Testing start.");
	}
	
	@Test
	public void test(){
		String s = "aniltako";
		Assert.assertEquals("aniltako", s);
	}

	@AfterSuite
	public void after(){
		System.out.println("Testing end.");
	}
	
}
