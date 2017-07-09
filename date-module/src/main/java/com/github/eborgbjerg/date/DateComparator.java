package com.github.eborgbjerg.date;


public class DateComparator {
	
	

	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return 0 iff date1 = date2
	 *         1 iff date1 > date2
	 *        -1 iff date1 < date2
	 */
	public int compare(final Date date1, final Date date2) {
		
		assert ( date1 != null  &&  date2 != null );

		
		if ( date1.equals(date2) ) {
			
			return 0;
		}
		
		else {
			
			if ( date1.getYear() == date2.getYear() ) {
				
				if ( date1.getMonth() == date2.getMonth() ) {
						
					if ( date1.getDay() > date2.getDay() ) {
						
						return 1;
					}
					
					else {
						
						return -1;
					}
				}
				
				else {
					
					if ( date1.getMonth() > date2.getMonth() ) {
						
						return 1;
					}
					
					else {
						
						return -1;
					}
					
				}
				
			}
			
			else {
				
				if ( date1.getYear() > date2.getYear() ) {
					
					return 1;
				}
				
				else {
					
					return -1;
				}
			}
		}

		
	}

}
