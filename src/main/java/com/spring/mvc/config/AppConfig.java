package com.spring.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//@WebAppConfiguration
//@EnableTransactionManagement
//@Import({MysqlDbConfig.class})
//@EnableJpaRepositories(basePackages="com.spring.mvc.dao")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spring.mvc"})
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
	
	@Scheduled(fixedRate = 1000)
	public void scheduleFixedRateTask() {
		logger.info("scheduler start");
	}
	
}