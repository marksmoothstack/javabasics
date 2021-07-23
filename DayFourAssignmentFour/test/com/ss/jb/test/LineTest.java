package com.ss.jb.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.jb.four.Line;

public class LineTest {

	// Generate instances of four different lines
	Line line = new Line(2, 3, 4, 5);
	Line line2 = new Line(2, 3, 4, 5);
	Line line3 = new Line(21, 5, 3, 15);
	Line line4 = new Line(2, 2, 2, 2);
	Line line5 = new Line(4, 5, 6, 7);

	// Test getSlope()
	@Test
	public void getSlopeTest() {

		// Ensure tested result is 1, added .0001 delta to account for rounding errors
		assertEquals(1, line.getSlope(), .0001);

		// Ensure that it does not always return one
		assertNotEquals(1, line3.getSlope(), .0001);

		// Test that method does not try to divide by zero
		assertNotEquals(0, line4.getSlope(), .0001);
	}

	// Test getDistance()
	@Test
	public void getDistanceTest() {

		// Check for correct distance
		assertEquals(8, line.getDistance(), .0001);

		// Ensure that a distance of eight is not always returned
		assertNotEquals(8, line3.getDistance(), .0001);
	}

	// Test parallelTo()
	@Test
	public void parallelToTest() {

		// Check that two identical lines are parallel
		assertTrue(line.parallelTo(line2));

		// Check that two different lines are parallel
		assertTrue(line.parallelTo(line5));

		// Check two non parallel lines to ensure true is not always returned
		assertFalse(line.parallelTo(line3));
	}
}
