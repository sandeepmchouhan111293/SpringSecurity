package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("admin").password("12345").authorities
	 * ("admin").and().withUser("Sandeep")
	 * .password("1234").authorities("read").and().passwordEncoder(
	 * NoOpPasswordEncoder.getInstance()); }
	 */
	
	//For In Memory storing of user details but along with it we have to provide password encoder
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		UserDetails user = User.withUsername("Admin").password("Admin").authorities("admin").build();
		UserDetails user1 = User.withUsername("Sandeep").password("1234").authorities("read").build();
		userDetailsManager.createUser(user);
		userDetailsManager.createUser(user1);
		auth.userDetailsService(userDetailsManager);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
