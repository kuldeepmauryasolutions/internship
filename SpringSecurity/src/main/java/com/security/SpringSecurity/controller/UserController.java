package com.security.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.SpringSecurity.entity.User;
import com.security.SpringSecurity.service.UserService;

@RestController
@RequestMapping("/ss")
public class UserController {
	private UserService userService;	
	@Autowired	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUserName(@PathVariable("id") int id, @RequestParam("name") String name) {
		return userService.updateUserName(id, name);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public boolean deleteUser(@PathVariable("id") int id) {
		return userService.deleteUser(id);
	}
	
	@GetMapping("/public")
	public String getPublic() {
		return "Hi this is public";
	}
}
