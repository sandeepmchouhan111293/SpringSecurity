package com.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * /account /balance /loan /cards /notices /contact
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		//  Custom Configuration for allowing some url and stop others 
		http
		  .authorizeRequests() .antMatchers("/account").authenticated()
		  .antMatchers("/balance").authenticated()
		  .antMatchers("/loan").authenticated() .antMatchers("/cards").authenticated()
		  .antMatchers("/notices").permitAll() .antMatchers("/contact").permitAll()
		  .and() .formLogin() .and() .httpBasic();
		  
		  
		 /* Deny All REquests irrespective of authorization and authentication
		  http.authorizeRequests().anyRequest().denyAll().and().formLogin().and().
		  httpBasic();
		 
		  
		 

		// Permit All REquests irrespective of authorization and authentication
		http.authorizeRequests().anyRequest().permitAll().and().formLogin().and().httpBasic();
		*/
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("12345").authorities("admin").and().withUser("Sandeep")
				.password("1234").authorities("read").and().passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
}
