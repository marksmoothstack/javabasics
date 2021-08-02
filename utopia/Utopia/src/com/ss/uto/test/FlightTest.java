package com.ss.uto.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.uto.domain.Flight;


public class FlightTest {
	@Test
	public void testAirportSetGet() {

		// Generate object
		Flight flight = new Flight();

		// Test that cases return correct result
		flight.setAirplaneID("1");
		assertTrue(flight.getAirplaneID().equals("1"));
		assertFalse(flight.getAirplaneID().equals("2"));
		
		flight.setDepartureTime("2021-06-16 16:00:00");
		assertTrue(flight.getDepartureTime().equals("2021-06-16 16:00:00"));
		assertFalse(flight.getDepartureTime().equals("2022-05-15 15:00:00"));
		
		flight.setFlightID("3");
		assertTrue(flight.getFlightID().equals("3"));
		assertFalse(flight.getFlightID().equals("1"));
		
		flight.setReservedSeats("20");
		assertTrue(flight.getReservedSeats().equals("20"));
		assertFalse(flight.getReservedSeats().equals("12"));
		
		flight.setRouteID("3");
		assertTrue(flight.getRouteID().equals("3"));
		assertFalse(flight.getRouteID().equals("2"));
		
		flight.setSeatPrice("250.00");
		assertTrue(flight.getSeatPrice().equals("250.00"));
		assertFalse(flight.getSeatPrice().equals("50.00"));
	}
}
