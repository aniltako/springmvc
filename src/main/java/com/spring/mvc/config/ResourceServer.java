//package com.spring.mvc.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServer extends ResourceServerConfigurerAdapter{
//
//	 private static final String RESOURCE_ID = "blog_resource";
//	
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//		resources.resourceId(RESOURCE_ID);
//	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		 http
//         .authorizeRequests().antMatchers("/").permitAll().and()
//     // default protection for all resources (including /oauth/authorize)
//         .authorizeRequests()
//             .anyRequest().hasRole("USER");
//     // ... more configuration, e.g. for form login
//		
////		// only secure channel, https, is allowed
////        http.requiresChannel().anyRequest().requiresSecure();
////
////        // static resources
////        http.authorizeRequests().antMatchers("/bootstrap/**").permitAll();
////
////        http.authorizeRequests().anyRequest().authenticated();
//		
//		
////		 http
////         .antMatcher("/**")
////         // Add below
////         .authorizeRequests()
////             .anyRequest().authenticated();
//		
//		// @formatter:off
////        http
////        // Just for laughs, apply OAuth protection to only 2 resources
////        .requestMatchers().antMatchers("/","/users/add").and()
////        .authorizeRequests()
////        .anyRequest().access("#oauth2.hasScope('read')"); //[4]
////        // @formatter:on
//	}
//
//	
//}
