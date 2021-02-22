package com.robertramirez.encolador;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Productor {

	public static void main(String[] args) throws Exception {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue("MyQueue");
		MessageProducer producer = session.createProducer(destination);
		
		String mensaje = "Prueba desde productor";
		TextMessage msg = session.createTextMessage(mensaje);
		producer.send(msg);
		System.out.println("Se envió mensaje!!");
		connection.close();
		System.exit(1);
		
	}
	
}
