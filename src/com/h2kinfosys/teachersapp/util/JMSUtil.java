package com.h2kinfosys.teachersapp.util;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.h2kinfosys.teachersapp.listeners.AugMessageListener;
import com.h2kinfosys.teachersapp.listeners.FirstSubscriber;
import com.h2kinfosys.teachersapp.listeners.SecondSubscriber;

public class JMSUtil {
	private String connectionURL = "tcp://localhost:61616";
	
	public Connection getConenction() {
		Connection conn = null;
		try {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
			factory.setBrokerURL(connectionURL);
			conn = factory.createConnection();
			conn.start();
		}catch(JMSException jmsEx) {
			jmsEx.printStackTrace();
		}
		return conn;
	}

	
	public void sendMessage(String textMessage) throws JMSException{
		try {
			Connection conn = getConenction();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination testqueue = session.createQueue("TEST.H2K.AUG2020");
			MessageProducer producer = session.createProducer(testqueue);
			Message message = session.createTextMessage(textMessage);
			producer.send(message);
			System.out.println("Message is sent to queue");
			closeConnection(conn);
		}catch(JMSException ex) {
			throw ex;
		}
	}
	
	public void sendMessageWithTransaction(String textMessage) throws JMSException{
		try {
			Connection conn = getConenction();
			Session session = conn.createSession(true, Session.SESSION_TRANSACTED);
			Destination testqueue = session.createQueue("TEST.H2K.AUG2020");
			MessageProducer producer = session.createProducer(testqueue);
			Message message = session.createTextMessage(textMessage);
			producer.send(message);
			session.commit();
			System.out.println("Message is sent to queue");
			closeConnection(conn);
		}catch(JMSException ex) {
			throw ex;
		}
	}
	
	
	public void sendMessageToTopic(String textMessage) throws JMSException{
		try {
			Connection conn = getConenction();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination testqueue = session.createTopic("TP.TEST.H2K.AUG2020");
			MessageProducer producer = session.createProducer(testqueue);
			Message message = session.createTextMessage(textMessage);
			producer.send(message);
			System.out.println("Message is sent to queue");
			closeConnection(conn);
		}catch(JMSException ex) {
			throw ex;
		}
	}
	
	public void readMessageFromQueue(String queName) throws JMSException{
		try {
			Connection conn = getConenction();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination testqueue = session.createQueue(queName);
			MessageConsumer consumer = session.createConsumer(testqueue);
			Message message = consumer.receive(200);
			System.out.println("Message is reeived " + message);
			closeConnection(conn);
		}catch(JMSException ex) {
			throw ex;
		}
	}
	
	public void startMessageSubscribers(String topicName) throws JMSException{
		try {
			Connection conn = getConenction();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination testTopic = session.createTopic(topicName);
			MessageConsumer consumerOne = session.createConsumer(testTopic);
			MessageConsumer consumerTwo = session.createConsumer(testTopic);
			consumerOne.setMessageListener(new FirstSubscriber());
			consumerTwo.setMessageListener(new SecondSubscriber());
		}catch(JMSException ex) {
			throw ex;
		}
	}
	
	public void startMessageListner(String queName) throws JMSException{
		try {
			Connection conn = getConenction();
			Session session = conn.createSession(false, Session.DUPS_OK_ACKNOWLEDGE);
			Destination testqueue = session.createQueue(queName);
			MessageConsumer consumer = session.createConsumer(testqueue);
			consumer.setMessageListener(new AugMessageListener());
		}catch(JMSException ex) {
			throw ex;
		}
	}
	
	
	
	
	public void closeConnection(Connection conn) {
		if(conn!= null) {
			try {
				conn.close();
			} catch (JMSException e) {
				System.out.println("Supressing Exception " + e);
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		JMSUtil util = new JMSUtil();
		try {
			//util.startMessageSubscribers("TP.TEST.H2K.AUG2020");
			//util.sendMessageToTopic("Package Arrived");
			//util.sendMessageWithTransaction("Package Arrived");
			util.startMessageListner("TEST.H2K.AUG2020");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
