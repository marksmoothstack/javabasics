/**
 * 
 */
package com.ss.jb.three;

/**
 * @author Mark Mocek
 *
 */
public class Rectangle implements Shape{
	
	// Create private variables to hold dimensions of rectangle
	private Double length;
	private Double height;
	
	// Create constructor that puts values from initialization arguments into private variables
	public Rectangle(Double l, Double h) {
		this.length = l;
		this.height = h;
	}
	
	// Return the area of the rectangle based on private variables
	@Override
	public Double calculateArea() {
		return this.length * this.height;
	}

	// Display method to show values of private variables
	@Override
	public void display() {
		System.out.println("Rectangle of length " + this.length + " and height " + this.height);
	}
}
