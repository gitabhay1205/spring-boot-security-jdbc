package com.security.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class SpringBootSecurityJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJdbcApplication.class, args);
	}
	
}
