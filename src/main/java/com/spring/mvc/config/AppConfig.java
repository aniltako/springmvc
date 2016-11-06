package com.spring.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.mvc")
public class AppConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	public void FirstMethod(){
		logger.info("Adding method");
	}
	
	public void SecondMethod(){
		logger.info("Adding method 2");
	}
	
	
	
}