package com.solutions.JWTSecurityDbUser.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.JWTSecurityDbUser.models.CustomUserDetails;
import com.solutions.JWTSecurityDbUser.services.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;
	
	//http://localhost:8080/home/user
	@GetMapping("/users")
	public List<CustomUserDetails> getUser() {
		System.out.println("Getting Users");
		return userService.getUsers();
	}
	
	@GetMapping("/currentUser")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
	
}
