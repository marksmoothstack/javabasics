package com.ss.jb.four;

import java.util.ArrayList;

public class PartFour {

	// Remove x from all strings in given list
	public static ArrayList<String> removeX(ArrayList<String> ar) {
		ar.replaceAll(n -> n.replace("x", ""));
		return ar;
	}

	public static void main(String[] args) {
		
		// Generate list of strings
		ArrayList<String> str = new ArrayList<String>();
		str.add("ax");
		str.add("bb");
		str.add("cx");
		
		// Display x-less strings
		System.out.println(removeX(str));
	}

}