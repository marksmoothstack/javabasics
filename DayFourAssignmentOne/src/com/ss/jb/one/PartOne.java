package com.ss.jb.one;

/*
 * 	Mark Mocek
 */
public class PartOne {

	// Make static instance variable for class, volatile is added to prevent cache
	// incoherence since partially initialized objects can be introduced into memory
	private static volatile PartOne instance;

	// Get static instance of class
	public static PartOne getInstance() {

		// Check to see if instance exists yet
		if (instance == null) {

			// If no instance of class exists, synchronize a check and create block to
			// ensure one initialization of the class
			synchronized (PartOne.class) {
				if (instance == null) {
					instance = new PartOne();
				}
			}
		}

		// Return the instance of the class
		return instance;
	}

	public static void main(String args[]) {

		System.out.println(getInstance());
		System.out.println(getInstance());
	}
}
