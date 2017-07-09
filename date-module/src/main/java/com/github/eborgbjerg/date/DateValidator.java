package com.github.eborgbjerg.date;



public class DateValidator {
	
	

	public void validate(final int day, final int month, final int year) {
		
		if ( day <= 0 ) {
			throw new IllegalArgumentException("day must be positive, was: " + day);
		}

		if ( month <= 0  ||  month > 12 ) {
			throw new IllegalArgumentException("month must be in range [1..12], was: " + month);
		}
		
		if ( day > MonthDayCount.get(month, year) ) {
			throw new IllegalArgumentException("day number is too large, was: " + day + " with month=" + month + " and year=" + year);
		}
		
	}

}
