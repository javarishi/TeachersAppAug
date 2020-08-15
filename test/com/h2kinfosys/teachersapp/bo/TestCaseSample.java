/**
 * 
 */
package com.h2kinfosys.teachersapp.bo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.h2kinfosys.teachersapp.exception.InvalidDataException;

/**
 * @author Rishi
 *
 */
public class TestCaseSample {
	
	TeachersBO bo = new TeachersBO("GA");

	@Test
	public void testValidateSkills_ex12() throws InvalidDataException {
		System.out.println("*** testValidateSkills_ex12 ***");
		int noOfYrs = 12;
		String actual_response = bo.validateSkills(noOfYrs);
		String expected = TeachersBO.Pro;
		assertEquals(actual_response, expected);
	}

}
