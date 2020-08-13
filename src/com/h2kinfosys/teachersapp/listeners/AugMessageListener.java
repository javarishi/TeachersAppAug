/**
 * 
 */
package com.h2kinfosys.teachersapp.listeners;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author Rishi
 *
 */
public class AugMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println(message);
		try {
			message.acknowledge();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
