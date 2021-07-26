package com.ss.jb.test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.ss.jb.two.PartTwo;

public class TestPartTwo {	
	
	@Test
	public void testRightMost() {
		
		// Generate list for method to alter
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(16);
		num.add(8);
		num.add(886);
		
		// Generate list of expected results
		ArrayList<Integer> num2 = new ArrayList<Integer>();
		num2.add(6);
		num2.add(8);
		num2.add(6);
		
		// Ensure results match expected
		assertEquals(num2, PartTwo.rightMost(num));
	}

}
