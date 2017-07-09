package com.github.eborgbjerg.date;
import static org.junit.Assert.*;

import org.junit.Test;

import com.github.eborgbjerg.date.Date;

import static com.github.eborgbjerg.date.Date.Factory.newDate;



public class FactoryTest {

	@Test
	public void testNormalDate() {
		
		Date d = newDate(1, 1, 2000); 
		
		assertEquals(2000, d.getYear());
		assertEquals(1, d.getDay());
		assertEquals(1, d.getMonth());
	}
	

	@Test(expected=Throwable.class)
	public void negativeDayFails() {
		
		newDate(-1, 1, 2000); 
	}

	
	@Test(expected=Throwable.class)
	public void zeroDayFails() {
		
		newDate(0, 1, 2000); 
	}
	

	@Test(expected=Throwable.class)
	public void negativeMonthFails() {
		
		newDate(1, -1, 2000); 
	}

	
	@Test(expected=Throwable.class)
	public void zeroMonthFails() {
		
		newDate(1, 0, 2000); 
	}

	
	@Test(expected=Throwable.class)
	public void badDayFails() {
		
		newDate(32, 1, 2000); 
	}


}
