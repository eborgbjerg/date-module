package com.github.eborgbjerg.date;


import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;




@RunWith(Parameterized.class)
public class InvalidDatesTest {

	private static DateValidator validator;
	
	
	@BeforeClass
	public static void setUpClass() {
		validator = new DateValidator();
	}
	
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {0, 1, 1} , {1, 0, 1}, {31, 13, 2000}, 
                 {32, 1, 1}, {29, 2, 1900}
           });
    }	


    private final int year, month, day;
    
    
    public InvalidDatesTest(final int day, final int month, final int year) {
    	this.year = year;
    	this.month = month;
    	this.day = day;
    }

	
	@Test(expected=Throwable.class)
	public void test() {
		
		validator.validate(day, month, year);
		
	}

}
