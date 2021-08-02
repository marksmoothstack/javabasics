package com.ss.uto.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.uto.domain.Airplane;

public class AirplaneTest {

	@Test
	public void testAirplaneSetGet() {

		// Generate object
		Airplane airplane = new Airplane();

		// Test that cases return correct result
		airplane.setAirplaneID("1");
		assertTrue(airplane.getAirplaneID().equals("1"));
		assertFalse(airplane.getAirplaneID().equals("2"));

		airplane.setAirplaneTypeID("4");
		assertTrue(airplane.getAirplaneTypeID().equals("4"));
		assertFalse(airplane.getAirplaneTypeID().equals("5"));
		
		airplane.setMaxCapacity("30");
		assertTrue(airplane.getMaxCapacity().equals("30"));
		assertFalse(airplane.getMaxCapacity().equals("50"));

	}
}
