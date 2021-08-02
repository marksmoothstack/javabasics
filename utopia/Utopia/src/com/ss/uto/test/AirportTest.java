package com.ss.uto.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.uto.domain.Airport;

public class AirportTest {
	@Test
	public void testAirportSetGet() {

		// Generate object
		Airport airport = new Airport();

		// Test that cases return correct result
		airport.setAirportCode("JFK");
		assertTrue(airport.getAirportCode().equals("JFK"));
		assertFalse(airport.getAirportCode().equals("JHK"));
		
		airport.setCity("San Jose");
		assertTrue(airport.getCity().equals("San Jose"));
		assertFalse(airport.getCity().equals("Jose San"));
	}
}
