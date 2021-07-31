package com.ss.jb.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.ss.jb.three.PartThree;

public class TestPartThree {
	
	@Test
	public void testThreeLetterA() {
		
		// Generate array list of strings
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("and");
		ar.add("nap");
		ar.add("pending");
		ar.add("apple");
		ar.add("are");
		ar.add("an");
		
		// Generate correct answer
		ArrayList<String> ar2 = new ArrayList<String>();
		ar2.add("and");
		ar2.add("are");
		
		// Generate wrong answer
		ArrayList<String> ar3 = new ArrayList<String>();
		ar3.add("apple");
		ar3.add("an");
		
		// Check to ensure function is only keeping the correct strings
		assertEquals(ar2, PartThree.threeLetterA(ar));
		assertNotEquals(ar3, PartThree.threeLetterA(ar));
	}
	
}
