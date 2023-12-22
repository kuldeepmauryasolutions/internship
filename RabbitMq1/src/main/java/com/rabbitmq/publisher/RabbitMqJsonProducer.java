package com.rabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitmq.dto.User;

@Service
public class RabbitMqJsonProducer {

	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.json.Key}")
	private String jsonKey;
	
	private RabbitTemplate rabbitTemplate;

	public RabbitMqJsonProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	private static final Logger LOGGER=LoggerFactory.getLogger(RabbitMqJsonProducer.class);
	
	public void sendJsonMessage(User user) {
		LOGGER.info(String.format("Json Message Sent -> %s",user.toString()));
		rabbitTemplate.convertAndSend(exchange,jsonKey,user);
	}
	
}
