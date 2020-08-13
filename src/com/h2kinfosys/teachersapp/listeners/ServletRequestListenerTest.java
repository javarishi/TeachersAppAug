package com.h2kinfosys.teachersapp.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletRequestListenerTest
 *
 */
@WebListener
public class ServletRequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {

 
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequestListenerTest :: attributeAdded " +srae.getName() + " Value " +  srae.getValue());
	}
	
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequestListenerTest :: attributeRemoved " +srae.getName() + " Value " +  srae.getValue());
	}
	
	
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequestListenerTest :: attributeReplaced " +srae.getName() + " Value " +  srae.getValue());
	}
	
	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	 System.out.println("ServletRequestListenerTest :: requestDestroyed ");
         sre.getServletRequest().removeAttribute("ApplicationName");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         System.out.println("ServletRequestListenerTest :: requestInitialized ");
         sre.getServletRequest().setAttribute("ApplicationName", "Teachers Application");
    }
	
}
