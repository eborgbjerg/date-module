package com.github.eborgbjerg.date;

import static com.github.eborgbjerg.date.Date.Factory.newDate;
import static org.junit.Assert.*;

import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class DaysInYearFromOrUntilDateTest {

	
	private static DistanceCalculator calculator;

	
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
            {newDate(1, 1, 2000),   365L, 1L},  // leap year
            {newDate(31, 12, 2000),   0L, 366L},
            {newDate(30, 12, 2000),   1L, 365L},
            {newDate(1, 1, 2001),   364L, 1L},  // non-leap year
            {newDate(1, 2, 2000),   334L, 32L},
           });
    }	

    
    private final Date date;
    private final long expectedDaysFrom, expectedDaysUntil;
    
    
    public DaysInYearFromOrUntilDateTest(final Date date, final long expectedDaysFrom, final long expectedDaysUntil) {
    	this.date = date;
    	this.expectedDaysFrom = expectedDaysFrom;
    	this.expectedDaysUntil = expectedDaysUntil;
    }
	
	
	@BeforeClass
	public static void setUpOnce() {
		
		calculator = new DistanceCalculator();
	}
	

	@Test
	public void test() {
		
		assertThat(calculator.daysInYearFromDate(date), equalTo(expectedDaysFrom));

		assertThat(calculator.daysInYearUntilDate(date), equalTo(expectedDaysUntil));
	}

}
