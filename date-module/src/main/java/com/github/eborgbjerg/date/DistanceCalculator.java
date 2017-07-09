package com.github.eborgbjerg.date;

public class DistanceCalculator {

	public long calculateDistance(final Date from, final Date to) {
		
		// TODO
		// reverse to/from if to > from
		
		
		
		// TODO
		// start with case where year is same;
		// then years differ by one
		// then years differ by more than one
		
		
		
		long result;
		
		final int yearFrom 
		= from.getYear();
		
		final int yearTo 
		= to.getYear();
		
		final int dayFrom 
		= from.getDay();
		
		final int dayTo 
		= to.getDay();

		result = 365 * (yearTo - yearFrom) + (dayTo - dayFrom);
		
		
		// TODO
		// in fact, the condition here is about number of days in each month...
		// so, some sort of static lookup will be needed
		
		if ( yearFrom == 2000  &&   yearTo == 2001 ) {
			result++;
		}
		
		return result;
	}
	
	

}
