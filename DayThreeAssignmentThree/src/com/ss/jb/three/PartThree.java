/**
 * 
 */
package com.ss.jb.three;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author Mark Mocek
 *
 */
public class PartThree {

	public static void main(String[] args) throws IOException {

		// Display error and exit program if argument is null, too many arguments are
		// entered, or the entered argument is not a single character
		if (args.length == 0 || args.length > 1 || args[0].length() > 1) {
			System.out.println("Invalid command line input. Only a single character is accepted.");
			System.exit(0);
		}

		// Open selected text file and reader
		InputStream file = new FileInputStream("src/com/ss/jb/three/text.txt");
		Reader reader = new InputStreamReader(file);

		// Create integer variable to hold character code and count variable to keep
		// track of occurrences
		int c, count = 0;

		// Empty string variable for character comparison
		String givenCharacter = null;

		// Iterate through text file and pull each character
		while ((c = reader.read()) != -1) {

			// Convert integer into string
			givenCharacter = "" + (char) c;

			// If the current character is equal to the given argument, increase counter by
			// 1
			if (givenCharacter.equals(args[0])) {
				count++;
			}
		}

		// Display count of given argument
		System.out.println(count);

		// Close reader
		reader.close();
	}

}
