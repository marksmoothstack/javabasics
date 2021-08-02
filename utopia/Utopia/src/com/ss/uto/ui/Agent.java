package com.ss.uto.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.service.AgentService;

public class Agent {

	private Scanner scan = new Scanner(System.in);

	public void agentMenu() throws SQLException {

		while (true) {
			System.out.println("1) Enter Flights You Manage");
			System.out.println("2) Quit to previous");

			String input = this.scan.nextLine();

			if (input.equals("1")) {
				flightSelect();
			} else if (input.equals("2")) {
				return;
			} else {
				System.out.println("Incorrect input.\n");
			}
		}
	}

	private void flightSelect() throws SQLException {
		readRoutes();
	}

	// Shows passenger table values
	private void readRoutes() throws SQLException {
		System.out.println("Read Routes");

		AgentService aserv = new AgentService();
		aserv.readRoutes();
		
		System.out.println("Type 'quit' to quit to previous");
		
		while (true) {

			String input = this.scan.nextLine();

			if (input.equals("1")) {
				flightDetails();
			} else if (input.equals("2")) {
				updateFlightDetails();
			} else if (input.equals("3")) {
				addSeats();
			} else if (input.equals("4")) {
				return;
			} else {
				System.out.println("Incorrect input.\n");
			}
		}
		return;
	}

	private void flightManage() {

		while (true) {
			System.out.println("1) View more details about the flight");
			System.out.println("2) Update the details of the Flight");
			System.out.println("3) Add Seats to Flight");
			System.out.println("4) Quit to previous");

			String input = this.scan.nextLine();

			if (input.equals("1")) {
				flightDetails();
			} else if (input.equals("2")) {
				updateFlightDetails();
			} else if (input.equals("3")) {
				addSeats();
			} else if (input.equals("4")) {
				return;
			} else {
				System.out.println("Incorrect input.\n");
			}
		}

	}

	private void flightDetails() {

		System.out.println(
				"You have chosen to view the Flight with Flight Id: X and Departure Airport: A and Arrival Airport: B. ");
		System.out.println(
				"Departure Airport: A | Arrival Airport: B | Departure Date: C | Departure Time: D | Arrival Date: E | Arrival Time: F");

		while (true) {
			System.out.println("Available Seats by Class:");
			System.out.println("1) First -> X");
			System.out.println("2) Business -> Y");
			System.out.println("3) Economy -> Z");
			System.out.println("4) Quit to previous");

			String input = this.scan.nextLine();

			if (input.equals("1")) {
				System.out.println("First -> X");
			} else if (input.equals("2")) {
				System.out.println("2) Business -> Y");
			} else if (input.equals("3")) {
				System.out.println("3) Economy -> Z");
			} else if (input.equals("4")) {
				return;
			} else {
				System.out.println("Incorrect input.\n");
			}
		}

	}

	private void updateFlightDetails() {

		System.out.println(
				"You have chosen to update the Flight with Flight Id: X and Flight Origin: A and Flight Destination: B. ");
		System.out.println("Enter ‘quit’ at any prompt to cancel operation.");

		String input = "";

		while (true) {

			System.out.println("Please enter new Origin Airport and City or enter N/A for no change:");
			input = this.scan.nextLine();

			System.out.println("Please enter new Destination Airport and City or enter N/A for no change:");
			input = this.scan.nextLine();

			System.out.println("Please enter new Departure Date or enter N/A for no change:");
			input = this.scan.nextLine();

			System.out.println("Please enter new Departure Time or enter N/A for no change:");
			input = this.scan.nextLine();

			System.out.println("Please enter new Arrival Date or enter N/A for no change:");
			input = this.scan.nextLine();

			System.out.println("Please enter new Arrival Time or enter N/A for no change:");
			input = this.scan.nextLine();

			System.out.println("UPDATE SUCCESSFUL" + input);
			return;
		}

	}

	private void addSeats() {

		String input = "";

		while (true) {
			System.out.println("Pick the Seat Class you want to add seats of, to your flight:");
			System.out.println("1) First");
			System.out.println("2) Business");
			System.out.println("3) Economy");
			System.out.println("4) Quit to cancel operation");

			input = this.scan.nextLine();

			if (input.equals("1")) {
				System.out.println("Existing number of seats: N");
				System.out.println("Enter new number of seats:");
				input = this.scan.nextLine();
			} else if (input.equals("2")) {
				System.out.println("Existing number of seats: N");
				System.out.println("Enter new number of seats:");
				input = this.scan.nextLine();
			} else if (input.equals("3")) {
				System.out.println("Existing number of seats: N");
				System.out.println("Enter new number of seats:");
				input = this.scan.nextLine();
			} else if (input.equals("4")) {
				return;
			} else {
				System.out.println("Incorrect input.\n");
			}
		}

	}
}
