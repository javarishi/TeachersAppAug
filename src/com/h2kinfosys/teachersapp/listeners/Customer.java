package com.h2kinfosys.teachersapp.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class Customer
 *
 */
@WebListener
public class Customer implements HttpSessionBindingListener {

    /**
     * Default constructor. 
     */
    public Customer() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event)  { 
         System.out.println("Customer :: I am going inside the Session ");
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	  System.out.println("Customer :: I am going outside the Session ");
    }
	
}
