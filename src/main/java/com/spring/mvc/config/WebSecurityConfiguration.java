package com.spring.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.spring.mvc.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		
//		
		//		http
//			.authorizeRequests().antMatchers("/anil").permitAll();
//		
//		http.authorizeRequests().anyRequest().authenticated();
		
//		http
//			//default protection for all resources (including /oauth/authorize)
//			.authorizeRequests()
//				.anyRequest().hasRole("USER");
//		
//			.antMatcher("/**")
//			.authorizeRequests()
//				.antMatchers("/", "/anil")
//				.permitAll()
//			.anyRequest()
//				.authenticated();
//	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/greeting");
	}

}
