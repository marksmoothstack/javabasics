/**
 * 
 */
package com.ss.jb.three;

/**
 * @author Mark Mocek
 *
 */
public class Circle implements Shape{
	
	// Create private variables to hold radius of circle
	private Double radius;
	
	// Create constructor that puts values from initialization argument into private variable
	public Circle(Double r) {
		this.radius = r;
	}
	
	// Return the area of the circle based on private variable
	@Override
	public Double calculateArea() {
		return Math.pow(this.radius, 2)*Math.PI;
	}

	// Display method to show values of private variable
	@Override
	public void display() {
		System.out.println("Circle of radius " + this.radius);
	}
}
