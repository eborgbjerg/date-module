package com.github.eborgbjerg.date;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class LeapYearCheckerTest {
	
	
	private static LeapYearChecker checker;
	
	
	@BeforeClass
	public static void setUpClass() {
		checker = new LeapYearChecker();
	}
	

	@Test
	public void test() {
	
		assertTrue(checker.isLeapYear(2000));
		assertTrue(checker.isLeapYear(0));
		assertTrue(checker.isLeapYear(1600));
		assertTrue(checker.isLeapYear(1200));

		assertFalse(checker.isLeapYear(2001));
		assertFalse(checker.isLeapYear(1700));
		assertFalse(checker.isLeapYear(1800));
		assertFalse(checker.isLeapYear(1900));
	}

}
