package com.ss.uto.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.domain.Flight;
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

			if (input.equals("quit")) {
				return;
			} else if (input.equals("1")) {
				flightManage();
			} else {
				System.out.println("Incorrect input.\n");
			}
		}
	}

	private void flightManage() throws SQLException {

		while (true) {
			System.out.println("1) View more details about the flight");
			System.out.println("2) Update the details of the Flight");
			System.out.println("3) Quit to previous");

			String input = this.scan.nextLine();

			if (input.equals("1")) {
				flightDetails();
			} else if (input.equals("2")) {
				updateFlightDetails();
			} else if (input.equals("3")) {
				return;
			} else {
				System.out.println("Incorrect input.\n");
			}
		}

	}

	private void flightDetails() throws SQLException {

		System.out.println("Flight Details: ");

		AgentService aserv = new AgentService();
		aserv.readFlight();

	}

	private void updateFlightDetails() throws SQLException {
		System.out.println("Update Flight");

		Flight flight = new Flight();

		System.out.println("Enter Flight ID:");
		flight.setFlightID(this.scan.nextLine());

		System.out.println("Change Route ID:");
		flight.setRouteID(this.scan.nextLine());

		System.out.println("Change Airplane ID:");
		flight.setAirplaneID(this.scan.nextLine());

		System.out.println("Change Departure Date: (xxxx-xx-xx xx:xx:xx)");
		flight.setDepartureTime(this.scan.nextLine());

		System.out.println("Change Number of Reserved seats:");
		flight.setReservedSeats(this.scan.nextLine());

		System.out.println("Change Seat Price:");
		flight.setSeatPrice(this.scan.nextLine());

		AgentService aserv = new AgentService();
		aserv.updateFlight(flight);

		return;
		

	}

//	private void addSeats() {
//
//		String input = "";
//
//		while (true) {
//			System.out.println("Pick the Seat Class you want to add seats of, to your flight:");
//			System.out.println("1) First");
//			System.out.println("2) Business");
//			System.out.println("3) Economy");
//			System.out.println("4) Quit to cancel operation");
//
//			input = this.scan.nextLine();
//
//			if (input.equals("1")) {
//				System.out.println("Existing number of seats: N");
//				System.out.println("Enter new number of seats:");
//				input = this.scan.nextLine();
//			} else if (input.equals("2")) {
//				System.out.println("Existing number of seats: N");
//				System.out.println("Enter new number of seats:");
//				input = this.scan.nextLine();
//			} else if (input.equals("3")) {
//				System.out.println("Existing number of seats: N");
//				System.out.println("Enter new number of seats:");
//				input = this.scan.nextLine();
//			} else if (input.equals("4")) {
//				return;
//			} else {
//				System.out.println("Incorrect input.\n");
//			}
//		}
//
//	}
}
