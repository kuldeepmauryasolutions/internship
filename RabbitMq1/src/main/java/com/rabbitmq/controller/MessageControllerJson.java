package com.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.dto.User;
import com.rabbitmq.publisher.RabbitMqJsonProducer;

@RestController
@RequestMapping("/message")
public class MessageControllerJson {
	
	private RabbitMqJsonProducer jsonProducer;

	public MessageControllerJson(RabbitMqJsonProducer jsonProducer) {
		this.jsonProducer = jsonProducer;
	}
	
	@PostMapping("/publishjson")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
		jsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("Json Message Sent to RabbitMQ...");
	}

}
