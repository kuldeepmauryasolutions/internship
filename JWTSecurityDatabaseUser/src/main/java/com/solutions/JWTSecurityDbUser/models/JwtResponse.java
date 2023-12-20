package com.solutions.JWTSecurityDbUser.models;

public class JwtResponse {
	private String jwtToken;
	private String username;
	public JwtResponse(String jwtToken, String username) {
		super();
		System.out.println("Jwt Response class constructor");
		this.jwtToken = jwtToken;
		this.username = username;
	}
	public JwtResponse() {
		super();
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static JwtResponse builder() {
		return new JwtResponse();
	}
	
}
