/**
 * 
 */
package assignmenttwo;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Mark Mocek
 *
 */


public class PartTwo {
	
	// Method to collect input from user
	public static int getNumber() {
		
		// Initialize scanner for user input
		Scanner userInput = new Scanner(System.in);
		
		// Ask user for  their guessed number
		System.out.print("Guess a number between 1-100: ");
		
		// Check if user input is an integer and recursively call function until correct input type is entered
		if(userInput.hasNextInt() == false) {
			System.out.println("Invalid input.");
			return getNumber();
		}
		
		// Place user input into variable
		int guessedNumber = userInput.nextInt();
		
		// Check if user input is within the allowed range and recursively call function until correct range is entered
		if(guessedNumber < 1 || guessedNumber > 100) {
			System.out.println("Invalid range.");
			return getNumber();
		}
		
		// Return validated input
		return guessedNumber;
	}
	
	public static void main(String[] args) {
		
		// Generate random number instance
		Random rand = new Random();
		
		// Choose number between 1 - 100 and set upper and lower limit
		int randomNumber = rand.nextInt(100) + 1;
		int randomNumberLowerLimit = randomNumber - 10;
		int randomNumberUpperLimit = randomNumber + 10;
		
		// Set number of guesses for user
	    int guessesLeft = 4;
	    
	    // Collect initial guess from user
	    int guessedNumber = getNumber();
	    
	    // Loop until user guesses correctly or runs out of 5 guesses
	    while(true) {
	    	
	    	// Check if user is out of guesses
	    	if(guessesLeft == 0)
	    	{
	    		System.out.println("Sorry, the number was " + randomNumber);
	    		break;
	    	}
	    	
	    	// Check if user guessed close enough to correct answer
	    	if( randomNumberLowerLimit < guessedNumber && guessedNumber < randomNumberUpperLimit) {
		    	System.out.println("You win. Number was: " + randomNumber);
		    	break;
		    }
	    	
	    	// Decrement guess counter on wrong input and inform user
		    else {
		    	System.out.println("Oops, keep guessing.");
		    	guessesLeft--;
		    }
	    	
	    	// Collect new guess from user
		    guessedNumber = getNumber();
	    }
	}
}
