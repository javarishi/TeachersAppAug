package com.h2kinfosys.teachersapp.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */

public class AuthenticationFilter implements Filter {

 
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		boolean errorFlag = false;
		
		if (userId != null && password != null) {
			if(password.equals(userId+"@123")) {
				System.out.println("Authenticated");
				chain.doFilter(request, response);
			}else {
				errorFlag = true;
			}
		}else {
			errorFlag = true;
		}
		if(errorFlag) {
			PrintWriter out = response.getWriter();
			out.println("UserID or Password is Invalid");
		}
		
		
	}


}
