package com.h2kinfosys.teachersapp.listeners;

import javax.jms.Message;
import javax.jms.MessageListener;

public class SecondSubscriber implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println(message + " SecondSubscriber " );

	}

}
