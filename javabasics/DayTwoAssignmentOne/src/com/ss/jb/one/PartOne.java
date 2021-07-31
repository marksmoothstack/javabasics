/**
 * 
 */
package com.ss.jb.one;

/**
 * @author Mark Mocek
 *
 */
public class PartOne {
	
	// Main method takes in command line arguments
	public static void main(String args[])
    {
		// Try catch block to catch invalid input type
		try {
			
			// Place each argument into an integer for adding
			Integer firstArgument = Integer.parseInt(args[0]);
	        Integer secondArgument = Integer.parseInt(args[1]);
	        Integer thirdArgument = Integer.parseInt(args[2]);
	        
	        // Variable to hold the sum of the command line arguments
	        Integer sum = firstArgument + secondArgument + thirdArgument;
	        
	        // Print out the arguments and the sum
	        System.out.println("The result of " + firstArgument + " + " + secondArgument +" + " + thirdArgument + " is " + sum);
		} 
		// Inform of invalid input if wrong data type is used
		catch(NumberFormatException e){
			System.out.println("Invalid input.");
		}
    }
}
