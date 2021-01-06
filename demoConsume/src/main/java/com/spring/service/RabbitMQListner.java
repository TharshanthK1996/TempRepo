package com.spring.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.model.OrderDetail;
@Service
public class RabbitMQListner {
	@RabbitListener(queues="${spring.rabbitmq.queue}")
	public void consumer(OrderDetail order) {
		System.out.println("Order detail:");
		System.out.println(order);
	}
	
}
