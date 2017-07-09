package com.github.eborgbjerg.date;

/**
 * 
 * Calculate distance in days between two given dates.
 *
 */
public class DistanceCalculator {
	
	
	private final DateComparator comparator;
	private final LeapYearChecker leapYearChecker; 
	
	
	public DistanceCalculator() {

		comparator = new DateComparator();
		leapYearChecker = new LeapYearChecker();
	}

	
	/**
	 * 
	 * @param from
	 * @param to
	 * @return distance measured in days between arguments.
	 */
	public long calculateDistance(final Date from, final Date to) {
		
		long result = 0;
		
		// reverse to/from if to > from

		
		final Date fromDate, toDate;
		
		if ( comparator.compare(from, to) > 0 ) {

			fromDate = to;
			toDate = from;
		}
		
		else {
			
			fromDate = from;
			toDate = to;
		}
		
	
		for ( int currentYear = fromDate.getYear();  currentYear <= toDate.getYear(); currentYear++ ) {

			result += getContributionOfYear(currentYear, fromDate, toDate);
		}
		
		
		return result;
	}

	
	/**
	 * 
	 * @param currentYear
	 * @param from
	 * @param to
	 * @return current years contribution to the distance between from/to. 
	 */
	private long getContributionOfYear(final int currentYear, final Date from, final Date to) {
		
		if ( currentYear > from.getYear()  &&  currentYear < to.getYear() ) {
			
			// a 'middle' year	
			
			return leapYearChecker.isLeapYear(currentYear) ?  366 : 365;
		}
		
		else if ( currentYear == from.getYear()  &&  currentYear < to.getYear() ) {
			
			// - number of days from fromDate in current year
			
			return daysInYearFromDate(from);
		}

		else if ( currentYear > from.getYear()  &&  currentYear == to.getYear() ) {
			
			// - number of days up until toDate in current year
			
			return daysInYearUntilDate(to);
		}

		else if ( currentYear == from.getYear()  &&  currentYear == to.getYear() ) {
			
			// - number of days between from/to within current year
			
			return daysInYearBetweenDates(from, to);
		}
		
		else {
			
			throw new IllegalStateException("Program logic error!");
		}

	}


	/**
	 * 
	 * @param from
	 * @param to
	 * @return distance between from/to - given that they are within the same year.
	 */
	private long daysInYearBetweenDates(final Date from, final Date to) {
		
		assert (from.getYear() == to.getYear());

		
		long result = 0;
		
		for ( int currentMonth = from.getMonth();  currentMonth <= to.getMonth(); currentMonth++ ) {

			result += getContributionOfMonth(currentMonth, from, to);
		}
		

		return result;
	}


	/**
	 * 
	 * @param currentMonth
	 * @param from
	 * @param to
	 * @return current months contribution to the distance between from/to, which are within same year.
	 */
	private long getContributionOfMonth(final int currentMonth, final Date from, final Date to) {

		if ( currentMonth == from.getMonth()  &&  currentMonth == to.getMonth() ) {
			
			return to.getDay() - from.getDay();
		}
		
		else {  // TODO
			
			return 0;
		}
		
		
	}


	private long daysInYearFromDate(final Date date) {
		return 0;  // TODO
	}


	private long daysInYearUntilDate(final Date date) {
		return 0; // TODO
	}


}
