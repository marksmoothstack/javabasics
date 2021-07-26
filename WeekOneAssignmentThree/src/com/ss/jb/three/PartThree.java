package com.ss.jb.three;

import java.util.ArrayList;

public class PartThree {

	// Multiply numbers from a given list of Integers by 2 and return them
	public static ArrayList<Integer> multiplyTwo(ArrayList<Integer> ar) {
		ar.replaceAll(n -> n * 2);
		return ar;
	}

	public static void main(String[] args) {
		
		// Generate list of integers
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(1);
		num.add(2);
		num.add(3);
		
		// Display trimmed integers
		System.out.println(multiplyTwo(num));
	}

}