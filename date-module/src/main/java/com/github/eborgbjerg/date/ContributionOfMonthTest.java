package com.github.eborgbjerg.date;

import static com.github.eborgbjerg.date.Date.Factory.newDate;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class ContributionOfMonthTest {


	private static DistanceCalculator calculator;

	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
            {1, newDate(1, 1, 2000), newDate(1, 1, 2000), 0L},
            {1, newDate(1, 1, 2000), newDate(2, 1, 2000), 1L},
            {1, newDate(1, 1, 2000), newDate(1, 2, 2000), 30L},
            {2, newDate(1, 1, 2000), newDate(1, 3, 2000), 29L},
            {3, newDate(1, 1, 2000), newDate(1, 3, 2000), 1L},
           });
    }	

    
    private final Date from, to;
    private final int month;
    private final long expected;
    

    public ContributionOfMonthTest(final int month, final Date from, final Date to, final long expected) {
    	this.from = from;
    	this.to = to;
    	this.expected = expected;
    	this.month = month;
    }
    
	
	@BeforeClass
	public static void setUpOnce() {
		
		calculator = new DistanceCalculator();
	}
    
    
	@Test
	public void test() {
		
		assertThat(calculator.getContributionOfMonth(month, from, to), equalTo(expected));
		
	}

}
