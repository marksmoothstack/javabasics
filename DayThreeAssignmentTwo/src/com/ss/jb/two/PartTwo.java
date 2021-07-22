/**
 * 
 */
package com.ss.jb.two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Mark Mocek
 *
 */
public class PartTwo {
	
	// Method takes string as argument and appends it to the designated file
	public static void addText(String givenString) {
		
		// Try catch block to handle file exception
		try {
			
			// Takes file path and appends the given string to that file
		    Files.write(Paths.get("src/com/ss/jb/two/textfile.txt"), givenString.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		
		// Calls method to append three different strings to the file
		addText("Line One \n");
		addText("Second Line \n");
		addText("Third \n");
		
	}
}
