package com.github.eborgbjerg.date;

import static org.junit.Assert.*;
import static com.github.eborgbjerg.date.Date.Factory.newDate;

import org.junit.BeforeClass;
import org.junit.Test;

public class DistanceCalculatorTest {
	
	private static DistanceCalculator calculator;
	
	
	@BeforeClass
	public static void setUpOnce() {
		
		calculator = new DistanceCalculator();
	}
	
	
	@Test
	public void test() {

		assertEquals(1, calculator.calculateDistance(newDate(1, 1, 2000), newDate(2, 1, 2000)));
	}
	
	
	@Test
	public void test2() {

		assertEquals(2, calculator.calculateDistance(newDate(1, 1, 2000), newDate(3, 1, 2000)));
	}
	
	
	@Test
	public void testLeapYear() {
		
		assertEquals(366, calculator.calculateDistance(newDate(1, 1, 2000), newDate(1, 1, 2001)));
	}


}
