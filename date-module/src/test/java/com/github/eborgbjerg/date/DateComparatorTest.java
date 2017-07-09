package com.github.eborgbjerg.date;


import static com.github.eborgbjerg.date.Date.Factory.newDate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


import org.junit.BeforeClass;
import org.junit.Test;

public class DateComparatorTest {
	
	
	private static DateComparator comparator;
	
	
	@BeforeClass
	public static void setUpClass() {
		
		comparator = new DateComparator();
	}
	

	@Test
	public void withInSameMonth() {
		
		assertThat(0, equalTo(comparator.compare(newDate(1, 1, 2000), newDate(1, 1, 2000))));
		assertThat(1, equalTo(comparator.compare(newDate(2, 1, 2000), newDate(1, 1, 2000))));
		assertThat(-1, equalTo(comparator.compare(newDate(1, 1, 2000), newDate(2, 1, 2000))));
	}

	
	@Test
	public void withInSameYear() {
		
		assertThat(1, equalTo(comparator.compare(newDate(2, 5, 2000), newDate(1, 3, 2000))));
		assertThat(-1, equalTo(comparator.compare(newDate(1, 2, 2000), newDate(2, 11, 2000))));
	}

	
	@Test
	public void inDifferentYear() {
		
		assertThat(1, equalTo(comparator.compare(newDate(2, 5, 2002), newDate(1, 3, 2000))));
		assertThat(-1, equalTo(comparator.compare(newDate(1, 2, 2000), newDate(2, 11, 2003))));
	}

}
