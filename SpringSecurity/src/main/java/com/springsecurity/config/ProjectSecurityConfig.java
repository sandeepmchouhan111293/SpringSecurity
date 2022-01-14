package com.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter{

	/* /account
	 * /balance
	 * /loan
	 * /cards
	 * /notices
	 *  /contact
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/account").authenticated()
		.antMatchers("/balance").authenticated()
		.antMatchers("/loan").authenticated()
		.antMatchers("/cards").authenticated()
		.antMatchers("/notices").permitAll()
		.antMatchers("/contact").permitAll()
		.and()
		.formLogin()
		.and()
		.httpBasic();
	}
}
