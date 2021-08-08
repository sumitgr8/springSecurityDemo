package com.demo.springSecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springsecurity/demo")
public class HelloController {
	
	@RequestMapping("/welcome/msg")
	public String getWelcomeMessage() {
		return "Hello Developers You are Welocome !!!!!!!!!!!!!!!";
		
	}

}
