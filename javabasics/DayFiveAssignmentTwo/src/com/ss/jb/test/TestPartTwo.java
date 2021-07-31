package com.ss.jb.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.ss.jb.two.PartTwo;

public class TestPartTwo {
	
	PartTwo pt = new PartTwo();
	
	@Test
	public void testAlterList() {
		// Generate array to test
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(12);
		ar.add(23);
		
		// Test that method produces correct result
		assertEquals("e12, o23", pt.alterList(ar));
		
		// Generate array to test
		ArrayList<Integer> ar2 = new ArrayList<Integer>();
		ar.add(11);
		ar.add(24);
		
		// Test that method does not have static return
		assertNotEquals("e11, o24", pt.alterList(ar));
	}
}
