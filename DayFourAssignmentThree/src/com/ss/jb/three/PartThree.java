/**
 * 
 */
package com.ss.jb.three;

import java.util.LinkedList;

/**
 * @author Mark Mocek
 *
 */
public class PartThree {

	public static void main(String[] args) throws InterruptedException {

		// Create instance of class with producer and consumer methods
		final ProducerConsumer pc = new ProducerConsumer();

		// Create producer thread
		Thread producerThread = new Thread() {

			// Run producer thread
			public void run() {
				try {

					// Call produce function to add an integer to the list
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		// Create consumer thread
		Thread consumerThread = new Thread() {

			public void run() {
				try {

					// Call consume function to remove an integer from the list
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		// Start threads
		producerThread.start();
		consumerThread.start();
	}

	// Class with list and producer/consumer methods
	public static class ProducerConsumer {

		// Create list for holding produced integers
		LinkedList<Integer> list = new LinkedList<>();

		// Producer adds growing integer to list
		public void produce() throws InterruptedException {

			// Generate number to increment and place in list
			int num = 0;

			// Infinite loop
			while (true) {
				synchronized (this) {

					// Stop once list reaches size 5 for more apparent producer consumer interaction
					while (list.size() == 5)
						wait();

					// Display the produced number
					System.out.println("Produced: " + num);

					// Place produced number into list
					list.add(num++);

					// Wake up consumer thread
					notify();

					// Slows down loop speed to make program easier to see in effect
					Thread.sleep(1000);
				}
			}
		}

		// Consumer removes produced integers from list
		public void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {

					// Wait if list is empty
					while (list.size() == 0)
						wait();

					// Remove item from list and save for display
					int val = list.removeFirst();

					// Display the consumed number
					System.out.println("Consumed: " + val);

					// Wake up producer thread
					notify();

					// Slows down loop speed to make program easier to see in effect
					Thread.sleep(1000);
				}
			}
		}
	}
}
