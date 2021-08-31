package com.demo.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springSecurity.Dto.UserDTO;
import com.demo.springSecurity.Jwt.JwtRequest;
import com.demo.springSecurity.Jwt.JwtResponse;
import com.demo.springSecurity.Service.MyUserDetailService;
import com.demo.springSecurity.Util.JwtTokenUtil;

@RestController
@RequestMapping("/springsecurity/demo/welcome")
public class HelloController {
	
	@Autowired
	MyUserDetailService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	/**
	 * Sample Method for Welcome Message
	 * @return
	 */
	@RequestMapping("/msg")
	public String getWelcomeMessage() {
		return "Hello Developers You are Welocome !!!!!!!!!!!!!!!";
		
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {


		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = userService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		
		
		return ResponseEntity.ok(userService.saveUserDetails(user));
	}

}
