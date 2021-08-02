package com.ss.uto.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.uto.domain.Passenger;



public class PassengerTest {
	@Test
	public void testAirportSetGet() {

		// Generate object
		Passenger passenger = new Passenger();

		// Test that cases return correct result
		passenger.setAddress("nowhere");
		assertTrue(passenger.getAddress().equals("nowhere"));
		assertFalse(passenger.getAddress().equals("somewhere"));
		
		passenger.setBookingId("1");
		assertTrue(passenger.getBookingId().equals("1"));
		assertFalse(passenger.getBookingId().equals("2"));
		
		passenger.setDob("2021/08/02");
		assertTrue(passenger.getDob().equals("2021/08/02"));
		assertFalse(passenger.getDob().equals("2120/80/40"));
		
		passenger.setFamilyName("last");
		assertTrue(passenger.getFamilyName().equals("last"));
		assertFalse(passenger.getFamilyName().equals("first"));
		
		passenger.setGender("M");
		assertTrue(passenger.getGender().equals("M"));
		assertFalse(passenger.getGender().equals("F"));
		
		passenger.setGivenName("first");
		assertTrue(passenger.getGivenName().equals("first"));
		assertFalse(passenger.getGivenName().equals("last"));
		
		passenger.setId("1");
		assertTrue(passenger.getId().equals("1"));
		assertFalse(passenger.getId().equals("2"));
	}
}
