package com.github.eborgbjerg.date;

public class Date {
	

	private final int day, month, year;
	
	
	private Date(final int day, final int month, final int year) {
		
		assert (day > 0);
		assert (month > 0);

		this.day = day; 
		this.month = month;
		this.year = year;
	}

	public int getYear() {

		return year;
	}

	public int getDay() {

		return day;
	}

	public int getMonth() {

		return month;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}


	static class Factory {
		
		static final DateValidator validator = new DateValidator();

		
		public static Date newDate(final int day, final int month, final int year) {
			
			validator.validate(day, month, year);
			
			return new Date(day, month, year);
		}
		
	}
	
}
