package com.spring.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@Import({MysqlDbConfig.class})
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.mvc")
public class AppConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	
	 @Bean
	 public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
	    {
	        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
	        ppc.setLocation(new ClassPathResource("config/config.properties"));
	        ppc.setIgnoreUnresolvablePlaceholders(true);
	        return ppc;
	    }
	
	public void FirstMethod(){
		logger.info("Adding method");
	}
	
}