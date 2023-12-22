package com.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.dto.User;

@Service
public class RabbitMqConsumerJson {

	private static final Logger LOGGER=LoggerFactory.getLogger(RabbitMqConsumerJson.class);
	
	@RabbitListener(queues= {"${rabbitmq.queue.json.name}"})
	public void consumeJsonMessage(User user) {
	LOGGER.info(String.format("Recieved JSON Message -> %s",user.toString()));
	}
}
