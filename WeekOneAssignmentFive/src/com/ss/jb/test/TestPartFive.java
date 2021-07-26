package com.ss.jb.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import com.ss.jb.five.PartFive;

public class TestPartFive {

	@Test
	public void testGroupSumClump() {

		// Generate new list and fill them with integers
		ArrayList<Integer> i1 = new ArrayList<Integer>();
		Collections.addAll(i1, 1, 2, 4, 8, 1);
		ArrayList<Integer> i2 = new ArrayList<Integer>();
		Collections.addAll(i2, 2, 4, 4, 8);

		// Test that cases return correct result
		assertTrue(PartFive.groupSumClump(0, i1, 14));
		assertFalse(PartFive.groupSumClump(0, i2, 14));
	}

}
