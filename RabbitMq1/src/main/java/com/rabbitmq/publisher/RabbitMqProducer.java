package com.rabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	
	@Value("${rabbitmq.routing.Key}")
	private String routingKey;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(RabbitMqProducer.class);
	
	
	//It is used or required to send the messages.
	private RabbitTemplate rabbitTemplate;
//  @Autowired
	public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	
	//method to send message
	public void sendMessage(String message) {
		LOGGER.info(String.format("Message sent -> %s",message));
		rabbitTemplate.convertAndSend(exchange,routingKey,message);
	}
	
}
