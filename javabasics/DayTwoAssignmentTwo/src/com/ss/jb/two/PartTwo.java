package com.ss.jb.two;

public class PartTwo {
	
	public static void main(String args[]) {
		
		// Create a 2D array with three rows of three
		Integer[][] twoDArr = new Integer[3][3];
		
		// Manually fill each position with an integer
		twoDArr[0][0] = 554;
		twoDArr[0][1] = 12;
		twoDArr[0][2] = -4687;
		twoDArr[1][0] = 1645;
		twoDArr[1][1] = 161;
		twoDArr[1][2] = 16;
		twoDArr[2][0] = -85;
		twoDArr[2][1] = 34;
		twoDArr[2][2] = 331;
		
		// Generate variables to hold largest number found and position it was found
		Integer currentMax = Integer.MIN_VALUE;
		Integer positionX = 0;
		Integer positionY = 0;
		
		// Nested for loop to iterate through each row and column of the array
		for(int i = 0; i < 3; i++) {
			for(int f = 0; f < 3; f++) {
				
				// If a larger number is found, replace value and position
				if(twoDArr[i][f] > currentMax) {
					currentMax = twoDArr[i][f];
					positionX = i;
					positionY = f;
				}
			}
		}
		
		// Display findings
		System.out.println("The largest number is " + currentMax + " at location [" + positionX + "][" + positionY + "]");
		
	}
}
