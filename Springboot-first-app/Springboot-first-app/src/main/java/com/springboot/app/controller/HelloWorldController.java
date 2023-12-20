package com.springboot.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {
	//get http method
	//http://localhost:8080/helloworld
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
}
