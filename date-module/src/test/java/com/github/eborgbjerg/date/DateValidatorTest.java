package com.github.eborgbjerg.date;


import org.junit.BeforeClass;
import org.junit.Test;

public class DateValidatorTest {
	
	
	private static DateValidator validator;
	
	
	@BeforeClass
	public static void setUpClass() {
		
		validator = new DateValidator();
	}
	

	@Test
	public void testValidDates() {

		// invalid dates causes exception throw
		// therefore no need to assert anything
		
		validator.validate(1, 1, 2000);
		validator.validate(31, 1, 2000);
		validator.validate(31, 12, 2000);
		validator.validate(29, 2, 2000);
		validator.validate(29, 2, 1600);
	}
	

}
