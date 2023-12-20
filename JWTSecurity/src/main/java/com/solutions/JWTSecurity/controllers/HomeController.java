package com.solutions.JWTSecurity.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.JWTSecurity.models.User;
import com.solutions.JWTSecurity.services.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;
	
	//http://localhost:8080/home/user
	@GetMapping("/users")
	public List<User> getUser() {
		System.out.println("Getting Users");
		return userService.getUsers();
	}
	
	@GetMapping("/currentUser")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
	
}
