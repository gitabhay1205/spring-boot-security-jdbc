package com.security.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@RequestMapping("/")
	public String hello() {
		
		return "Welcome all";
	}
	
	@GetMapping("/user")
	public String user() {
		
		return "Hello User";
	}
	
	@GetMapping("/admin")
	public String admin() {
		
		return "Hello Admin";
	}
	
}
