package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.OrderDetail;
import com.spring.service.RabbitMQSender;

@RestController
@RequestMapping(path = "Order")
public class OrderDetailController {
	@Autowired
	RabbitMQSender rabbitMWQSender;
	
	@PostMapping()
	public String OrderCreate(@RequestBody OrderDetail order) {
		rabbitMWQSender.sendMessage(order);
		return "order created";
	}
}
