package com.h2kinfosys.teachersapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet(description = "RequestServlet to understand Request Object", urlPatterns = { "/request", "/req" })

public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Enumeration<String> paramNames = request.getParameterNames();
		PrintWriter out = response.getWriter();
		out.println("<HTML> <BODY>");
		
		String name = null;
		while(paramNames.hasMoreElements()) {
			name = paramNames.nextElement();
			out.println("<p> <h1> Parameter Name " +  name 
							+ " Value " + request.getParameter(name)  
							+ " </h1> <p> ");
		
		}
		
		Enumeration<String> headers = request.getHeaderNames();
		String headerName = null;
		while(headers.hasMoreElements()) {
			headerName = headers.nextElement();
			out.println("<p> <h3> Header Name " +  headerName 
							+ " Header Value " + request.getHeader(headerName)  
							+ " </h3> <p> ");
		
		}
		
		request.setAttribute("userId", "Rishi");
		request.setAttribute("userId", "David");
		request.setAttribute("Account_Number", 23234324);
		request.setAttribute("password", "Rishi@123");
		request.removeAttribute("password");
		// 1. Check if session exists - if not exists - create new
		HttpSession session = request.getSession();
		out.println("<p>  Session is Created  <p> ");
		out.println("<p> " + session.getCreationTime() + " <p> ");
		
		ServletContext context = getServletContext();
		
		out.println("<p> requestKey1 " + request.getAttribute("requestKey1") + " <p> ");
		out.println("<p> requestKey2 " + request.getAttribute("requestKey2") + " <p> ");
		out.println("<p> SessionKey1 " + session.getAttribute("SessionKey1") + " <p> ");
		out.println("<p> SessionKey2 " + session.getAttribute("SessionKey2") + " <p> ");
		out.println("<p> contextKey1 " + context.getAttribute("contextKey1") + " <p> ");
		out.println("<p> contextKey2 " + context.getAttribute("contextKey2") + " <p> ");

		
		
		out.println("<p> " + request.getContextPath() + " <p> ");
		
	
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie eachCookie : cookies) {
				out.println("<p> Cookie Name " +  eachCookie.getName() 
						+ " Cookie Value " + eachCookie.getValue()  
						+ " <p> ");
			}
		}
		
		
		
		out.println(" </BODY> </HTML>");
		
	}

}
