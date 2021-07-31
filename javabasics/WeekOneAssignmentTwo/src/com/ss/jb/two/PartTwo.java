package com.ss.jb.two;

import java.util.ArrayList;

public class PartTwo {
	
	// Take the trailing number from a given list of Integers and return them
	public static ArrayList<Integer> rightMost(ArrayList<Integer> ar) {
		ar.replaceAll(n -> n % 10);
		return ar;
	}

	public static void main(String[] args) {
		
		// Generate list of integers
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(1);
		num.add(22);
		num.add(93);
		
		// Display trimmed integers
		System.out.println(rightMost(num));
	}

}
