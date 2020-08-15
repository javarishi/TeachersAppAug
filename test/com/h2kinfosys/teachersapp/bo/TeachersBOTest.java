package com.h2kinfosys.teachersapp.bo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.h2kinfosys.teachersapp.exception.InvalidDataException;

public class TeachersBOTest {
	
	TeachersBO bo = new TeachersBO("GA");
	
	@BeforeClass
	public static void init(){
		System.out.println("Setup Before Class");
		//bo = new TeachersBO("GA");
	}
	
	@AfterClass
	public static void destroy(){
		System.out.println("Tear Down After Class");
	}
	
	@Before
	public void addBeforeMethod() {
		System.out.println("*** Start ***");
	}
	
	@After
	public void addAfterMethod() {
		System.out.println("*** End ***");
	}

	@Test
	public void testValidateSkills_valid() throws InvalidDataException {
		System.out.println("*** testValidateSkills_valid ***");
		int noOfYrs = 5;
		String actual_response = bo.validateSkills(noOfYrs);
		String expected = TeachersBO.Experienced;
		assertEquals(actual_response, expected);
		
	}
	
	@Test(expected = InvalidDataException.class)
	public void testValidateSkills_invalid() throws InvalidDataException {
		System.out.println("*** testValidateSkills_invalid ***");
		int noOfYrs = -5;
		bo.validateSkills(noOfYrs);
	}
	
	@Test
	public void testValidateSkills_ex3() throws InvalidDataException {
		System.out.println("*** testValidateSkills_ex3 ***");
		int noOfYrs = 3;
		String actual_response = bo.validateSkills(noOfYrs);
		String expected = TeachersBO.Prelim;
		assertEquals(actual_response, expected);
		
	}

	
	@Test
	public void testValidateSkills_ex10() throws InvalidDataException {
		System.out.println("*** testValidateSkills_ex10 ***");
		int noOfYrs = 10;
		String actual_response = bo.validateSkills(noOfYrs);
		String expected = TeachersBO.Experienced;
		assertEquals(actual_response, expected);
	}
}
