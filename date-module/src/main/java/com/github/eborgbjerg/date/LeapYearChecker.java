package com.github.eborgbjerg.date;



public class LeapYearChecker {

	
	
	public boolean isLeapYear(final int year) {
		
		if ( year % 4 != 0 ) {
			
			return false;
		}
		
		else {
			
			// divisible by 4...
			
			if ( year % 100 != 0 ) {
				
				return true;
			}
			
			else {
				
				// divisible by 100
				
				return year % 400 == 0;
			}
			
		}
	}

}
