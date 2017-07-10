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
        	
        				// many examples taken from www.timeanddate.com
        	
	            {newDate(1, 1, 2000),  newDate(1, 1, 2000),   0},
	            {newDate(1, 1, 2000),  newDate(2, 1, 2000),   1},
	            {newDate(1, 1, 2000),  newDate(3, 1, 2000),   2},
	            {newDate(30, 12, 2001),  newDate(31, 12, 2001),   1},
	            {newDate(1, 2, 2012),  newDate(2, 2, 2012),   1},
	            {newDate(1, 2, 2012),  newDate(2, 3, 2012),   30},
	            
	            {newDate(27, 2, 2012),  newDate(2, 3, 2012),   4},
	            {newDate(27, 2, 2012),  newDate(1, 3, 2012),   3},
	            {newDate(27, 2, 2012),  newDate(29, 2, 2012),   2},
	            {newDate(27, 2, 2012),  newDate(28, 2, 2012),   1},

	            {newDate(28, 2, 2012),  newDate(2, 3, 2012),   3},
	            {newDate(28, 2, 2012),  newDate(1, 3, 2012),   2},
	            {newDate(28, 2, 2012),  newDate(29, 2, 2012),   1},
	            {newDate(28, 2, 2012),  newDate(28, 2, 2012),   0},
	            
	            {newDate(27, 2, 2012),  newDate(2, 3, 2013),   369},
	            {newDate(1, 11, 2013),  newDate(1, 12, 2013),   30},
	            {newDate(1, 1, 2000),  newDate(1, 1, 2001),   366},

	            {newDate(1, 1, 2000),  newDate(1, 1, 2100),   36525},  
	            {newDate(1, 1, 1900),  newDate(1, 1, 2100),   73049},  
	            {newDate(1, 1, 1900),  newDate(1, 1, 2200),   109573},  
	            {newDate(1, 1, 1800),  newDate(1, 1, 2200),   146097},  
	            {newDate(1, 1, 1800),  newDate(1, 1, 2300),   182621},  
	            {newDate(1, 1, 1700),  newDate(1, 1, 2300),   219145},  // 219135 according to www.timeanddate.com  
	            														// 182621 + 36524 = 219145
	            
	            {newDate(1, 1, 1600),  newDate(1, 1, 2300),   255670},  // 255660 according to www.timeanddate.com
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
		assertEquals(expectedDistance, calculator.calculateDistance(date2, date1));
	}


}
