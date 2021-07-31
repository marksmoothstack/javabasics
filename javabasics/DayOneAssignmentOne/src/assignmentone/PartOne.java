/**
 * 
 */
package assignmentone;

/**
 * @author Mark Mocek
 *
 */
public class PartOne {

	/* 
	 * Create four static methods since class will not be holding any state
	*/
	
	// Generates tree of asterisks aligned to the left
	public static void leftTree() {
		
		// Print tree number
		System.out.println("1)");
		
		// For loop prints out asterisk based on iterator
		for(int i = 1; i < 5; i++) {
			System.out.println("*".repeat(i));
		}
		
		// Print dotted line with 9 .'s
		System.out.println(".".repeat(9));
	}
	
	// Generates tree of asterisks aligned to the left and inverted
	public static void leftTreeInverted() {
		
		// Print tree number
		System.out.println("2)");
		
		// Print dotted line with 10 .'s
		System.out.println(".".repeat(10));
		
		// For loop prints out asterisk based on iterator in descending order
		for(int i = 4; i > 0; i--) {
			System.out.println("*".repeat(i));
		}
	}
	
	// Generates tree of asterisks center aligned
	public static void centerTree() {
		
		// Print tree number
		System.out.println("3)");
		
		// Create separate counter for asterisks
		int askCounter = 1;
		
		// For loop prints out spaces based on iterator in descending order with incrementing asterisks
		for(int i = 5; i > 1; i--) {
			System.out.print(" ".repeat(i));
			System.out.println("*".repeat(askCounter));
			
			// Increase asterisk counter by 2
			askCounter += 2;
		}
		
		// Print dotted line with 11 .'s
		System.out.println(".".repeat(11));
	}
	
	// Generates tree of asterisks center aligned and inverted
	public static void centerTreeInverted() {
		
		// Print tree number
		System.out.println("4)");
		
		// Print dotted line with 12 .'s
		System.out.println(".".repeat(12));
		
		// Create separate counter for asterisks
		int askCounter = 7;
		
		// For loop prints out spaces based on iterator in ascending order with decrementing asterisks
		for(int i = 2; i < 6; i++) {
			System.out.print(" ".repeat(i));
			System.out.println("*".repeat(askCounter));
			
			// Decrease asterisk counter by 2
			askCounter -= 2;
		}
	}
	
	public static void main(String[] args) {
		
		// Call each function to generate its corresponding tree
		leftTree();
		leftTreeInverted();
		centerTree();
		centerTreeInverted();

	}

}
