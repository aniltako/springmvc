package com.spring.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.spring.mvc.service.CustomUserDetailsService;

@Configuration
public class OAuth2Config{
	private static String REALM="MY_OAUTH_REALM";
	private static final String RESOURCE_ID = "restservice";
	
	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends
		ResourceServerConfigurerAdapter{
		
		@Override
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			//@formatter:off
			resources
				.resourceId(RESOURCE_ID).stateless(false);
			//@formatter:on
		}
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
			//@formatter:off
			
			  http.
		        anonymous().disable()
		        .requestMatchers().antMatchers("/users/**")
		        .and().authorizeRequests()
		        .antMatchers("/users/**").access("hasRole('ADMIN')")
		        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
			
//			http
//			.authorizeRequests()
//				.antMatchers("/users").hasRole("ADMIN")
//				.antMatchers("/greeting").authenticated();
			
//			 // only secure channel, https, is allowed
//	           http.requiresChannel().anyRequest().requiresSecure();
//
//	           // static resources
//	           http.authorizeRequests().antMatchers("/bootstrap/**").permitAll();
//
//	           http.authorizeRequests().anyRequest().authenticated();
//			
			
//			http
//				.authorizeRequests()
//					.antMatchers("/anil").hasRole("ADMIN")
//					.antMatchers("/tako").authenticated();
			
			//@formatter:on
			
		}
		
	}
	
	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfiguration extends
		AuthorizationServerConfigurerAdapter{
		
		@Autowired
		private TokenStore tokenStore;
		
		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;
		
		@Autowired
		private CustomUserDetailsService userDetailsService;
		
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			//@formatter:off
			endpoints
				.tokenStore(this.tokenStore)
				.userDetailsService(userDetailsService)
				.authenticationManager(this.authenticationManager);
			//@formatter:on
		}
		
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			//@formatter:off
			clients
				.inMemory()
					.withClient("clientapp")
						.authorizedGrantTypes("password","refresh_token")
						.authorities("USER")
						.scopes("read","write")
						.resourceIds(RESOURCE_ID)
						.secret("123");
			//@formatter:on
		}
		
		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
			security.realm(REALM+"/client");
		}
		
		@Bean
		@Primary
		public DefaultTokenServices tokenServices(){
			DefaultTokenServices tokenServices = new DefaultTokenServices();
			tokenServices.setSupportRefreshToken(true);
			tokenServices.setTokenStore(this.tokenStore);
			return tokenServices;
		}
		
		@Bean
		public TokenStore tokenStore(){
			return new InMemoryTokenStore();
		}
	
		
		
	}
}
