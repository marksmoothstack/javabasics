package com.ss.jb.two;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PartTwo {

	// Method takes array and adds either e or o prefix depending on even or odd
	// state of number
	public static String alterList(ArrayList<Integer> ar) {

		// Place input into string
		String str = ar.stream().map(a -> {

			// If number is odd prefix 'o' otherwise prefix 'e'
			if (a % 2 == 0) {
				return "e" + a;
			} else {
				return "o" + a;
			}
		}).collect(Collectors.joining(", "));

		return str;
	}

	public static void main(String[] args) {

		// Create list of integers
		ArrayList<Integer> ar = new ArrayList<Integer>();

		ar.add(12);
		ar.add(23);
		ar.add(87);
		ar.add(6);
		ar.add(42);
		ar.add(7);

		// Display result of method
		System.out.println(alterList(ar));

	}

}
