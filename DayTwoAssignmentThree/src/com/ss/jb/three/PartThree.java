/**
 * 
 */
package com.ss.jb.three;

/**
 * @author Mark Mocek
 *
 */
public class PartThree {
	
	public static void main(String args[]) {
		
		// Create instance for each class Rectangle, Triangle, and Circle with size arguments
		Rectangle r = new Rectangle(12.0, 15.0);
		Triangle t = new Triangle(10.0, 20.0);
		Circle c = new Circle(30.0);
		
		// Use Rectangle methods to access and display private values and area
		r.display();
		System.out.println("Rectangle area is " + r.calculateArea());
		
		// Use Triangle methods to access and display private values and area
		t.display();
		System.out.println("Triangle area is " + t.calculateArea());
		
		// Use Circle methods to access and display private values and area
		c.display();
		System.out.println("Circle area is " + c.calculateArea());
	}

}
