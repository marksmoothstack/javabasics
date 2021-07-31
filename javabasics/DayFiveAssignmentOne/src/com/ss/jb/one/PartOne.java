package com.ss.jb.one;

import java.util.ArrayList;
import java.util.Arrays;

public class PartOne {

	public static void main(String[] args) {

		ArrayList<String> words = new ArrayList<String>();
		words.add("one");
		words.add("two");
		words.add("three");
		words.add("four");
		words.add("five");
		words.add("six");
		words.add("seven");

		// Sort shortest to longest
		words.sort((a, b) -> a.length() - b.length());
		System.out.println(words);

		// Sort longest to shortest
		words.sort((a, b) -> b.length() - a.length());
		System.out.println(words);

		// Sort alphabetically by first letter only
		words.sort((a, b) -> a.charAt(0) - b.charAt(0));
		System.out.println(words);

		// Sort by words that contain e
		words.sort((a, b) -> a.contains("e") ? -1 : 1);
		System.out.println(words);

		// Sort alphabetically by first letter only using helper
		words.sort((a, b) -> Utils.yourMethod(a, b));
		System.out.println(words);
	}
}
