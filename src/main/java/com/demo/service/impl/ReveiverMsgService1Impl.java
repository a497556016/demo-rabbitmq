package com.demo.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.demo.service.ReceiverMsgService;

@Service
@RabbitListener(queues="sayHi")
public class ReveiverMsgService1Impl implements ReceiverMsgService {

	@Override
	@RabbitHandler
	public void receiveHiMsg(String hello) {
		System.out.println("I'm receiver2, receive one msg :"+hello);
	}

}
