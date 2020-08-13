package com.h2kinfosys.teachersapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextServlet
 */
@WebServlet("/Context")
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		context.setAttribute("contextKey1", "ContextValue_One");
		context.setAttribute("contextKey2", "ContextValue_Two");
		request.setAttribute("RegionCode", "GA");
		
		
		RequestDispatcher rd = context.getRequestDispatcher("/teachers");
		rd.forward(request, response);
		
		
	}

}
