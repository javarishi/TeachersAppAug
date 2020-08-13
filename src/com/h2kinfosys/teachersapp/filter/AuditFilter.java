package com.h2kinfosys.teachersapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuditFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) 
			throws ServletException {
		System.out.println("AuditFilter :: init ");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// Pre-processing - req
			System.out.println("IP Address of client :: " + req.getRemoteAddr());
		// chain
			chain.doFilter(req, res);
		// Post processor - res
			System.out.println("Response Content Type :: " + res.getContentType());

	}
	
	@Override
	public void destroy() {
		System.out.println("AuditFilter :: destroy ");
	}

}
