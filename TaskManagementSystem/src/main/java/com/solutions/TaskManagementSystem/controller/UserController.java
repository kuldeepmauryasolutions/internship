package com.solutions.TaskManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.TaskManagementSystem.entity.Task;
import com.solutions.TaskManagementSystem.entity.UserInfo;
import com.solutions.TaskManagementSystem.service.UserService;

@EnableAutoConfiguration 
@RestController
@RequestMapping("/ums")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody UserInfo userInfo) {
		return userService.createUser(userInfo);	
	}
	

}
