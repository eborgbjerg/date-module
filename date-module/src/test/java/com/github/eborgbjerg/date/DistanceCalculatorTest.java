package com.github.eborgbjerg.date;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import static com.github.eborgbjerg.date.Date.Factory.newDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class DistanceCalculatorTest {
	
	private static DistanceCalculator calculator;
	
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
	            {newDate(1, 1, 2000),  newDate(1, 1, 2000),   0},
	            {newDate(1, 1, 2000),  newDate(2, 1, 2000),   1},
	            {newDate(1, 1, 2000),  newDate(3, 1, 2000),   2},
	            {newDate(30, 12, 2001),  newDate(31, 12, 2001),   1},
	      //      {newDate(1, 11, 2013),  newDate(1, 12, 2013),   30},
//	            {newDate(1, 1, 2000),  newDate(1, 1, 2001),   366},
           });
    }	
	
    
    final Date date1, date2;
    final int expectedDistance;
    
    
    public DistanceCalculatorTest(final Date date1, final Date date2, final int expectedDistance ) {

    	this.date1 = date1;
    	this.date2 = date2;
    	this.expectedDistance = expectedDistance;
    }
    
	
	@BeforeClass
	public static void setUpOnce() {
		
		calculator = new DistanceCalculator();
	}
	

	@Test
	public void test() {
		assertEquals(expectedDistance, calculator.calculateDistance(date1, date2));
	}


}
