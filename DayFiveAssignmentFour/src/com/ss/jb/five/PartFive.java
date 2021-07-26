package com.ss.jb.five;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class PartFive {

	/*
	 * 5. Write an example that, for a given year, reports the length of each month
	 * within that year.
	 */
	public static void monthLength(int year) {

		// Iterate through months
		for (Month m : Month.values()) {

			// Print out month and days
			System.out.printf("%s has %d days.\n", m, YearMonth.of(year, m).lengthOfMonth());
		}
	}

	/*
	 * 6. Write an example that, for a given month of the current year, lists all of
	 * the Mondays in that month.
	 */
	public static void mondaysMonth(Month month) {

		// Display month
		System.out.printf("Month: %s:%n", month);

		// For given month, find date of each Monday in the current year
		LocalDate d = Year.now().atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		Month m = d.getMonth();
		while (m == month) {
			System.out.printf("%s\n", d);
			d = d.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			m = d.getMonth();
		}
	}

	/*
	 * 7. Write an example that tests whether a given date occurs on Friday the
	 * 13th.
	 */
	public static void fridayThirteenth(LocalDate d){
		
		// Check if date is the 13th and if date is Friday
		if(((d.get(ChronoField.DAY_OF_MONTH) == 13) && (d.get(ChronoField.DAY_OF_WEEK) == 5))) {
			System.out.printf("%s is Friday the thirteenth.\n", d);
		}
		else {
			System.out.printf("%s is not Friday the thirteenth.\n", d);
		}
	}

	public static void main(String[] args) {
		/*
		 * 1. Which class would you use to store your birthday in years, months, days,
		 * seconds, and nanoseconds? I would use the ZonedDateTime class. Period class
		 * helps convert ZonedDateTime into years/months/days.
		 * 
		 * 2. Given a random date, how would you find the date of the previous Thursday?
		 * todayDate.with(TemporalAdjuster.previous(DayOfWeek.THURSDAY))
		 * 
		 * 3. What is the difference between a ZoneId and a ZoneOffset? ZoneId is the
		 * same as ZoneOffSet except that ZoneId also uses ZoneRules count different in
		 * area and time.
		 * 
		 * 4. How would you convert an Instant to a ZonedDateTime? How would you convert
		 * a ZonedDateTime to an Instant? ZoneDateTime.ofInstant(Instant.now(),
		 * ZoneId.systemDefault()) will convert the instant to the ZoneDateTime,
		 * ZonedDateTime.now().toInstant() will get you back to the Instant.
		 */
		
		// Check length of months for year 2021
		System.out.println("5)");
		monthLength(2021);
		
		// Check date for Fridays in June
		System.out.println("\n6)");
		mondaysMonth(Month.valueOf("JUNE"));
		
		
		// Check if August 13th is a Friday the 13th
		System.out.println("\n7)");
		fridayThirteenth(Year.now().atMonth(Month.valueOf("AUGUST")).atDay(13));

	}

}
