package com.h2kinfosys.teachersapp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.h2kinfosys.teachersapp.listeners.Customer;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// Create new session 
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		session.setMaxInactiveInterval(180); // seconds 
		out.println("<HTML> <BODY>");
		// Creation time
		out.println(" <p> getCreationTime :: " + session.getCreationTime() + " </p> "); 
		out.println(" <p> getId :: " + session.getId() + " </p> "); 
		out.println(" <p> getLastAccessedTime :: " + session.getLastAccessedTime() + " </p> "); 
		out.println(" <p> getMaxInactiveInterval :: " + session.getMaxInactiveInterval() + " </p> "); 
		out.println(" <p> getId :: " + session.isNew() + " </p> "); 
		
		
		out.println("<p> contextKey1 " + session.getId() + " " + context.getAttribute("contextKey1") + " <p> ");
		out.println("<p> contextKey2 " + session.getId() + " " + context.getAttribute("contextKey2") + " <p> ");

		Customer cust = new Customer();
		
		session.setAttribute("customer", cust);
		session.setAttribute("SessionKey1", "SessionValue_one");
		session.setAttribute("SessionKey2", "SessionValue_two");
		
		request.setAttribute("requestKey1", "requestValue_one");
		request.setAttribute("requestKey2", "requestValue_two");
		out.println(" </BODY> </HTML>");
	}

}
