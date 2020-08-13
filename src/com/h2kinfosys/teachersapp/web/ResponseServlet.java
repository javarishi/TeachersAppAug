package com.h2kinfosys.teachersapp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/resp")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<HTML> <BODY>");
		//response.setContentType("application/pdf"); // MIME type
		
		Cookie cookieOne = new Cookie("Name", "David");
		Cookie cookieTwo = new Cookie("Account", "Checking");
		response.addCookie(cookieOne);
		response.addCookie(cookieTwo);
		
		
		response.sendRedirect("https://www.h2kinfosys.com");
		out.println(" </BODY> </HTML>");
	}

}
