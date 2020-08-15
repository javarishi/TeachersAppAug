package com.h2kinfosys.teachersapp.bo;

import com.h2kinfosys.teachersapp.dao.TeacherDAO;
import com.h2kinfosys.teachersapp.dto.TeacherTO;
import com.h2kinfosys.teachersapp.exception.InvalidDataException;

public class TeachersBO {

	private TeacherDAO dao = null;
	final static String Prelim  = "Prelim Teacher";
	final static String Experienced  = "Experienced Teacher";
	final static String Pro  = "Pro Teacher";
	
	public TeachersBO(String regionCode) {
		dao = new TeacherDAO();
	}

	public String executeCreateNewTeacher(TeacherTO teacher) throws InvalidDataException {
		// validation of object
		String message = null;
		if(teacher != null) {
			int numberofRowsInserted = dao.createTeacher(teacher);
			if(numberofRowsInserted > 0) {
				message = "Teacher Inserted Successfully";
				// Step 1   - Create XML of teacher information
				
				// Step 2 - Publish this XML into ActiveMQ Queue
				
			}else {
				message = "Unable to Insert Teacher";
			}
		}
		return message;
	}
	
	
	public String executeGetTeachersDetails(String id) {
		if(id != null && id.length() > 0) {
			System.out.println("ID Received :: " + id);
			// DB Call
			int intId = Integer.parseInt(id);
			if(intId == 100) {
				return "Neil Armstrong";
			}else if(intId == 200) {
				return "David Nix";
			}
			return "New Teacher";
		}
		return "Invalid Id Provided";
	}
	
	// Write test cases for this add it in Suite
	public boolean validateAge(int age) {
		return false;
	}
	
	
	public String validateSkills(int noOfYrs) throws InvalidDataException {
		String result = null;
		if(noOfYrs >= 0) {
			if(noOfYrs <= 3) {
				result = "Prelim Teacher";
			}else if (noOfYrs <= 10) {
				result = "Experienced Teacher";
			}else {
				result = "Pro Teacher";
			}
		}else {
			throw new InvalidDataException("Invalid Experience Entered ");
		}
		return result;
	}
	
	public static void main(String[] args) throws InvalidDataException {
		TeachersBO bo = new TeachersBO("GA");
		System.out.println(bo.validateSkills(11));
		
	}
}
