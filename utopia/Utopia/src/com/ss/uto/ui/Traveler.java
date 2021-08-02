package com.ss.uto.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.domain.Flight;
import com.ss.uto.domain.Passenger;
import com.ss.uto.service.AdminService;
import com.ss.uto.service.TravellerService;

public class Traveler {

	private Scanner scan = new Scanner(System.in);
	Passenger passenger = new Passenger();

	public void travelerMenu() throws SQLException {

		// Have user enter membership number until the correct one is entered
		while (true) {
			System.out.println("Enter the your Membership Number:");
			String input = this.scan.nextLine();

			TravellerService tserv = new TravellerService();
			passenger = tserv.findPassenger(input);

			// if member does not exist, throws out of bounds error
			// handle error or make an isValid method
			if (passenger.getId().equals(input)) {
				break;
			} else {
				System.out.println("Invalid Membership Number.\n");
			}
		}

		// Traveler main menu
		while (true) {
			System.out.println("1) Book a Ticket");
			System.out.println("2) Cancel an Upcoming Trip");
			System.out.println("3) Quit to Previous");

			String input = this.scan.nextLine();

			if (input.equals("1")) {
				bookTicket();
			} else if (input.equals("2")) {
				cancelTrip();
			} else if (input.equals("3")) {
				return;
			} else {

				// Inform user of error and repeat loop
				System.out.println("Incorrect input.\n");
			}
		}
	}

	private void bookTicket() throws SQLException {
		
		System.out.println("Pick the Flight you want to book a ticket for:");
		readFlight();
		
		System.out.println("Select Flight ID:");
		String flightId = this.scan.nextLine();
		
		TravellerService tserv = new TravellerService();
		tserv.bookFlight(flightId, passenger);
	}
	
	private void cancelTrip() throws SQLException {
		
		System.out.println("Pick the Flight you want to cancel:");
		TravellerService tserv = new TravellerService();
		tserv.readBookedFlight(passenger.getId());
		
		System.out.println("Select Flight ID:");
		String flightId = this.scan.nextLine();
		
		tserv.cancelFlight(flightId, passenger);
	}

	// Shows flight table values
	private void readFlight() throws SQLException {
		TravellerService tserv = new TravellerService();
		tserv.readFlight();

		return;
	}

//	private void selectSeat() {
//
//		System.out.println("Pick the Seat you want to book a ticket for:");
//
//		while (true) {
//			System.out.println("1) View Flight Details");
//			System.out.println("2) Quit to cancel operation");
//
//			String scan = this.scan.nextLine();
//
//			if (scan.equals("1")) {
//				System.out.println("View Flight Details");
//			} else if (scan.equals("2")) {
//				return;
//			} else {
//				System.out.println("Incorrect input.\n");
//			}
//		}
//	}
}
