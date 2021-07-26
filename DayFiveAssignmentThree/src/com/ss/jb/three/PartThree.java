package com.ss.jb.three;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PartThree {
	
	// Method takes in array list and returns altered list
	public static ArrayList<String> threeLetterA(ArrayList<String> a){
		
		// Filter out words that do not start with 'a' and are not exactly 3 letters long
		return (ArrayList<String>) a.stream().filter((str) -> str.charAt(0) == 'a' && str.length() == 3).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		
		// Array list to hold string values
		ArrayList<String> ar = new ArrayList<String>();
		
		// Add group of string values
		ar.add("and");
		ar.add("nap");
		ar.add("pending");
		ar.add("apple");
		ar.add("are");
		ar.add("an");
		
		// Display the results of the altered list
		System.out.println(threeLetterA(ar));
	}
}
