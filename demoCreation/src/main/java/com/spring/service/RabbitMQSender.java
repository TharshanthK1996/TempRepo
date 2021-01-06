package com.spring.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.model.OrderDetail;
@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${spring.rabbitmq.exchange}")
	private String exchange;
	@Value("${spring.rabbitmq.routingKey}")
	private String routingKey;
	
	public void sendMessage(OrderDetail order) {
		System.out.println(order);
		amqpTemplate.convertAndSend(exchange, routingKey, order);
	}
}
