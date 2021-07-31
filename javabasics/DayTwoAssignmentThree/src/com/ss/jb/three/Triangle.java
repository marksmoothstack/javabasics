/**
 * 
 */
package com.ss.jb.three;

/**
 * @author Mark Mocek
 *
 */
public class Triangle implements Shape{

	// Create private variables to hold dimensions of triangle
	private Double length;
	private Double height;
	
	// Create constructor that puts values from initialization arguments into private variables
	public Triangle(Double l, Double h) {
		this.length = l;
		this.height = h;
	}
	
	// Return the area of the triangle based on private variables
	@Override
	public Double calculateArea() {
		return .5*this.length*this.height;
	}

	// Display method to show values of private variables
	@Override
	public void display() {
		System.out.println("Triangle of length " + this.length + " and height " + this.height);
	}
}
