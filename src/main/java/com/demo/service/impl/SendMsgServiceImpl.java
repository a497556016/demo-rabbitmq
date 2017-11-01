package com.demo.service.impl;

import java.util.UUID;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.service.SendMsgService;

@Service
public class SendMsgServiceImpl implements SendMsgService,ConfirmCallback {
	@Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Override
	public void sayHi(String hello) {
		rabbitTemplate.setConfirmCallback(this);
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString()); 
		System.out.println("send uuid:"+correlationData.getId());
		rabbitTemplate.convertAndSend("exchange", "sayHi.1", hello, correlationData);
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("confirm uuid:"+correlationData.getId());
		if(ack) {
			System.out.println("send msg success!");
		}else {
			System.out.println("send msg failtur!");
		}
	}

}
