/**
 * 
 */
package com.ss.jb.two;

/**
 * @author Mark Mocek
 *
 */
public class PartTwo {

	// Create two locks for thread
	String first = "F", second = "S";

	// Create thread
	Thread threadOne = new Thread() {

		// Run thread that grabs first lock and waits before trying to grab second lock,
		// when second lock is taken during this time the thread will be deadlocked
		public void run() {
			try {
				
				// Grab first lock
				synchronized (first) {
					
					// Sleep timer to allow other thread to grab lock
					Thread.sleep(100);
					
					// Attempt to grab second lock and announce success
					synchronized (second) {
						System.out.println("threadTwo has both locks");
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	// Create thread
	Thread threadTwo = new Thread() {
		
		// Run thread that grabs second lock and waits before trying to grab first lock,
		// when first lock is taken during this time the thread will be deadlocked
		public void run() {
			try {
				
				// Grab second lock
				synchronized (second) {
					
					// Sleep timer to allow other thread to grab lock
					Thread.sleep(100);
					
					// Attempt to grab first lock and announce success
					synchronized (first) {
						System.out.println("threadTwo has both locks");
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	public static void main(String[] args) {
		
		// Create instance of class
		PartTwo pt = new PartTwo();

		// Show starting point
		System.out.println("Before thread call.");

		// Run both threads
		pt.threadOne.start();
		pt.threadTwo.start();

		// Show ending point
		System.out.println("After thread call.");

	}

}
