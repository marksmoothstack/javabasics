package com.ss.uto.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.uto.domain.Booking;


public class BookingTest {
	@Test
	public void testAirportSetGet() {

		// Generate object
		Booking booking = new Booking();

		// Test that cases return correct result
		booking.setId("1");
		assertTrue(booking.getId().equals("1"));
		assertFalse(booking.getId().equals("2"));
		
		booking.setIsActive("1");
		assertTrue(booking.getIsActive().equals("1"));
		assertFalse(booking.getIsActive().equals("0"));
		
		booking.setConfirmationCode("1234567");
		assertTrue(booking.getConfirmationCode().equals("1234567"));
		assertFalse(booking.getConfirmationCode().equals("1234576"));
	}
}
