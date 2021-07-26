package com.ss.jb.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.ss.jb.four.PartFour;

public class TestPartFour {

	@Test
	public void testRemoveX() {

		// Generate list for method to alter
		ArrayList<String> str = new ArrayList<String>();
		str.add("xxax");
		str.add("xbxbx");
		str.add("xxcx");

		// Generate list of expected results
		ArrayList<String> str2 = new ArrayList<String>();
		str2.add("a");
		str2.add("bb");
		str2.add("c");

		// Generate list for method to alter
		ArrayList<String> str3 = new ArrayList<String>();
		str3.add("x");

		// Generate list of expected results
		ArrayList<String> str4 = new ArrayList<String>();
		str4.add("");
		

		// Ensure results match expected
		assertEquals(str2, PartFour.removeX(str));
		assertEquals(str4, PartFour.removeX(str3));
	}

}