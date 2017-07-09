package com.github.eborgbjerg.date;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonthDayCount {

	
	static LeapYearChecker leapYearChecker = new LeapYearChecker();
	
	static List<Integer> dayCount;
	

	static { 
		dayCount = new ArrayList<Integer>();
		Collections.addAll(dayCount, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31); 
	}
	
	
	public static int get(final int month, final int year) {
		
		if ( month == 2  &&  leapYearChecker.isLeapYear(year) ) {
			return 29;
		}

		return dayCount.get(month - 1); // month is 1-based
	}

}
