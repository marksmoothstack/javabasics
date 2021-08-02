package com.ss.uto.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.uto.domain.Route;

public class RouteTest {

	@Test
	public void testAirportSetGet() {

		// Generate object
		Route route = new Route();

		// Test that cases return correct result
		route.setRouteId("1");
		assertTrue(route.getRouteId().equals("1"));
		assertFalse(route.getRouteId().equals("2"));
		
		route.setOriginAirport("JFK");
		assertTrue(route.getOriginAirport().equals("JFK"));
		assertFalse(route.getOriginAirport().equals("SJC"));
		
		route.setDestAirport("SJC");
		assertTrue(route.getDestAirport().equals("SJC"));
		assertFalse(route.getDestAirport().equals("JFK"));
	}
}
