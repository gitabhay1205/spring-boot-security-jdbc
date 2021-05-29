package com.security.boot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled "
				+ " from myusers "
				+ "where username=? ")
		.authoritiesByUsernameQuery("select username, authority "
				+ " from myauthorities "
				+ " where username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//order of matcher should always be from most restrictive to least restrictive
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll()   //permits acccess to every role
		.and().formLogin();
		
	}
	
	@Bean
	public PasswordEncoder getencoder() {
		 // Bean of PasswordEncoder is necessary as we cannot give passowrd as String text
		//but here we are returning No pass encdoer bean which actually does no encoding it return password as string only
		//ideally we should not use noOp encoder 
		return NoOpPasswordEncoder.getInstance();
	}

}
