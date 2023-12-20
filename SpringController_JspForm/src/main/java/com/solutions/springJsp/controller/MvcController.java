package com.solutions.springJsp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.solutions.springJsp.entity.User;
import com.solutions.springJsp.service.MvcService;

@Controller
public class MvcController {
	private final MvcService service;
	public MvcController(MvcService service) {
		this.service=service;
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Going Home...");
		return "index";
	}
	
	@RequestMapping("/userForm")
	public String form() {
		System.out.println("Going to form...");
		return "form";
	}
	
	@RequestMapping(value="/submitForm", method = RequestMethod.POST)
	public String registerUser(User user) {
		System.out.println("Registering User..");
		service.registerUser(user);
		return "register";
	}

	
	@RequestMapping("/registeredUsers")
	public String registeredUsers(Model model) {
		List<User> users=service.getUsers();
		System.out.println("Showing Users...");
		model.addAttribute("users", users);
		return "resultPage";
	}
	
	
	
}
