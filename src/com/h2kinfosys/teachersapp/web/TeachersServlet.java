package com.h2kinfosys.teachersapp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2kinfosys.teachersapp.bo.TeachersBO;
import com.h2kinfosys.teachersapp.dto.TeacherTO;
import com.h2kinfosys.teachersapp.exception.InvalidDataException;
import com.h2kinfosys.teachersapp.util.ConnectionUtil;

/*
 * request URL -> http://localhost:8080/TeachersApp/teachers
 */

public class TeachersServlet extends HttpServlet{

	TeachersBO teachersBO = null;
	@Override
	public void init() throws ServletException {
		System.out.println("TeachersServlet :: init() ");
		// region code from tomcat
		ServletConfig config = getServletConfig();
		String regionCode = config.getInitParameter("RegionCode");
		teachersBO = new TeachersBO(regionCode);
	}
	
	
	// GET
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" TeachersServlet : doGet " + req);
		String id = req.getParameter("id"); // URL Parameters
		
		String details = teachersBO.executeGetTeachersDetails(id);
		
		PrintWriter out = resp.getWriter();
		out.println("<HTML> <BODY>");
		out.println("<p> <h3> Teachers Application </h3> <p> ");
		out.println("<p> <h2> RegionCode " + req.getAttribute("RegionCode") + " </h2> <p> ");
		out.println(" </BODY> </HTML>");
		
		Cookie cookie = new Cookie("Teacher_ID", id);
		resp.addCookie(cookie);
		
		resp.flushBuffer();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherTO teacher = new TeacherTO();
		teacher.setFirstName(req.getParameter("firstName"));
		teacher.setLastName( req.getParameter("lastName"));
		teacher.setSkill(req.getParameter("skill"));
		String result = null;
		String companyName = null;
		try {
			
			result = teachersBO.executeCreateNewTeacher(teacher);
			companyName = ConnectionUtil.getCompanyName();
		} catch (InvalidDataException e) {
			result = e.getMessage();
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<HTML> <BODY>");
		out.println("<p> <h3>" + companyName + "</h3> <p> ");
		out.println("<p> <h3>" + result + "</h3> <p> ");
		out.println(" </BODY> </HTML>");
	}
	
	@Override
	public void destroy() {
		System.out.println("TeachersServlet :: destroy() ");
	}

}
