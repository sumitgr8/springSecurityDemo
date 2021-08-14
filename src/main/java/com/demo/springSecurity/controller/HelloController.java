package com.demo.springSecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springsecurity/demo/welcome")
public class HelloController {
	
	/**
	 * Sample Method for Welcome Message
	 * @return
	 */
	@RequestMapping("/msg")
	public String getWelcomeMessage() {
		return "Hello Developers You are Welocome !!!!!!!!!!!!!!!";
		
	}
	
	@RequestMapping("/seller")
	public String getWelcomeMessageSales() {
		return "Hello Sellers You are Welocome !!!!!!!!!!!!!!!";
		
	}
	
	@RequestMapping("/investor")
	public String getWelcomeMessageInvestor() {
		return "Hello Invetors You are Welocome !!!!!!!!!!!!!!!";
		
	}
	
	@RequestMapping("/user")
	public String getWelcomeMessageUsers() {
		return "Hello Users You are Welocome !!!!!!!!!!!!!!!";
		
	}
	
	@RequestMapping("/admin")
	public String getWelcomeMessageAdmin() {
		return "Hello Admin You are Welocome !!!!!!!!!!!!!!!";
		
	}

}
