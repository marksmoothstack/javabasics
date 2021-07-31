/**
 * 
 */
package com.ss.jb.one;

/**
 * @author Mark Mocek
 *
 */
import java.io.File;

public class PartOne {

	// Method to recursively search through directories
	public static void showFiles(String location, String indent) {

		// Try catch block to handle error if an empty directory is searched
		try {

			// Use passed location argument to check current directory and fill the array
			// with results
			File file = new File(location);
			String[] fileList = file.list();

			// Iterate through array of files in current directory
			for (String item : fileList) {

				// Print out the items in the current directory
				System.out.println(indent + "- " + item);

				// Append a the current items to the end of the current directory to create a
				// new location string
				String locationNew = location + "\\" + item;

				// Call method to check sub directory and adjust styled indent variable
				showFiles(locationNew, "     " + indent);
			}
		} catch (Exception e) {
		}
	}

	public static void main(String a[]) {

		// Call method with argument for current directory and starter point for style
		// string
		showFiles(".", "");

	}
}
