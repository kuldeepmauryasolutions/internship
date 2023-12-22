package com.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rabbitmq.publisher.RabbitMqProducer;

@RestController
@RequestMapping("/message")
public class MessageController {

	private RabbitMqProducer producer;
	@Autowired
	public MessageController(RabbitMqProducer producer) {
		this.producer = producer;
	}
	
	//http://localhost:8080/api/v1/publish?message=hello
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		System.out.println("Controller Working");
		producer.sendMessage(message);
		return ResponseEntity.ok("Message Send to RabbitMq..");
	}
	
}
