package com.ss.jb.one;

// Functional Interface for lambdas
interface PerformOperation {
	boolean check(int a);
}

public class PartOne {
	
	// Checker implementation
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	// Check if number is odd and return true if it is or false if it is even
	public static PerformOperation isOdd() {
		return a -> (a % 2 != 0) ? true : false;
	}

	// Check if number is prime and return true if it is or false if it is not
	public static PerformOperation isPrime() {
		return a -> {
			for (int i = 2; i * i <= a; i++) {
				if (a % i == 0) {
					return false;
				}
			}
			return true;
		};
	}

	// Check if number is palindrome and return true if it is or false if it is not
	public static PerformOperation isPalindrome() {
		return a -> a == Integer.parseInt(new StringBuilder(String.valueOf(a)).reverse().toString()) ? true : false;
	}

	public static void main(String[] args) {
		// Create interface variable
		PerformOperation op;
		boolean ret = false;

		// Check how many operations will be done and double for use, set incrementer to one
		Integer operations = Integer.valueOf(args[0]) * 2;
		int i = 1;

		// Cycle through input and subject to indicated test
		while (i <= operations) {
			switch (Integer.valueOf(args[i])) {
			// Display odd or even
			case 1:
				op = PartOne.isOdd();
				ret = PartOne.checker(op, Integer.valueOf(args[i + 1]));
				System.out.println((ret) ? "ODD" : "EVEN");
				break;
			// Display prime or composite
			case 2:
				op = PartOne.isPrime();
				ret = PartOne.checker(op, Integer.valueOf(args[i + 1]));
				System.out.println((ret) ? "PRIME" : "COMPOSITE");
				break;
			//Display palindrome or not
			case 3:
				op = PartOne.isPalindrome();
				ret = PartOne.checker(op, Integer.valueOf(args[i + 1]));
				System.out.println((ret) ? "PALINDROME" : "NOT PALINDROME");
				break;
			}
			i += 2;
		}

	}
}
