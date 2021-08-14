package com.demo.springSecurity.Jwt;

public class JwtResponse {
	

	private final String jwtToken;
	
	public JwtResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}



	public String getJwtToken() {
		return this.jwtToken;
	}
	
	

}
