package com.jms.first.time;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectPublish {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();
		
		String message = "Mobile Queue! ";
		//basicPublish(Exchange, routing-key, properties, message)
		channel.basicPublish("Direct-Exchange", "mobile", null, message.getBytes());
		channel.close();
		connection.close();
	}
}
