package com.ss.jb.test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.ss.jb.three.PartThree;

public class TestPartThree {	
	
	@Test
	public void testMultiplyTwo() {
		
		// Generate list for method to alter
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(6);
		num.add(8);
		num.add(6);
		num.add(8);
		num.add(-1);
		
		// Generate list of expected results
		ArrayList<Integer> num2 = new ArrayList<Integer>();
		num2.add(12);
		num2.add(16);
		num2.add(12);
		num2.add(16);
		num2.add(-2);
		
		// Generate list for method to alter
		ArrayList<Integer> num3 = new ArrayList<Integer>();
		
		// Generate list of expected results
		ArrayList<Integer> num4 = new ArrayList<Integer>();
		
		// Ensure results match expected
		assertEquals(num2, PartThree.multiplyTwo(num));
		assertEquals(num3, PartThree.multiplyTwo(num4));
	}

}