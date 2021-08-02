package com.ss.uto.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.domain.Airport;
import com.ss.uto.domain.Booking;
import com.ss.uto.domain.Flight;
import com.ss.uto.domain.Passenger;
import com.ss.uto.domain.Route;
import com.ss.uto.service.AdminService;

public class Admin {

	private Scanner scan = new Scanner(System.in);

	public void adminMenu() throws SQLException {

		while (true) {
			System.out.println("1) Add/Update/Delete/Read Flights");
			System.out.println("2) Add/Update/Delete/Read Tickets and Passengers");
			System.out.println("3) Add/Update/Delete/Read Airports");
			System.out.println("4) Add/Update/Delete/Read Travelers");
			System.out.println("5) Add/Update/Delete/Read Employees");
			System.out.println("6) Over-ride Trip Cancellation for a ticket.");
			System.out.println("7) Quit to previous");

			String input = this.scan.nextLine();

			if (input.equals("1")) {
				crudFlight();
			} else if (input.equals("2")) {
				crudPassengers();
			} else if (input.equals("3")) {
				crudAirport();
			} else if (input.equals("4")) {
				crudPassengers();
			} else if (input.equals("5")) {
				crudPassengers();
			} else if (input.equals("6")) {
				ticketCancelationOverRide();
			} else if (input.equals("7")) {
				return;
			} else {
				System.out.println("Incorrect input.\n");
			}
		}
	}

	private void crudFlight() throws SQLException {
		System.out.println("Add/Update/Delete/Read Flights");
		while (true) {
			System.out.println("1) Add");
			System.out.println("2) Update");
			System.out.println("3) Delete");
			System.out.println("4) Read");
			System.out.println("5) Quit to previous");

			String input = this.scan.nextLine();

			if (input.equals("1")) {
				addFlight();
			} else if (input.equals("2")) {
				updateFlight();
			} else if (input.equals("3")) {
				deleteFlight();
			} else if (input.equals("4")) {
				readFlight();
			} else if (input.equals("5")) {
				return;
			} else {
				System.out.println("Incorrect input.\n");
			}
		}

	}

	// Collects data from user to create a new flight
	private void addFlight() throws SQLException {
		System.out.println("Add Flight");

		Flight flight = new Flight();
		Route route = new Route();

		System.out.println("Enter Departure Airport:");
		route.setOriginAirport(this.scan.nextLine());

		System.out.println("Enter Arrival Airport:");
		route.setDestAirport(this.scan.nextLine());

		System.out.println("Enter Departure Date: (xxxx-xx-xx xx:xx:xx)");
		flight.setDepartureTime(this.scan.nextLine());

		System.out.println("Enter Number of Reserved seats:");
		flight.setReservedSeats(this.scan.nextLine());

		System.out.println("Enter Seat Price:");
		flight.setSeatPrice(this.scan.nextLine());

		flight.setAirplaneID("1");
		AdminService aserv = new AdminService();
		aserv.addFlight(flight, route);

		return;
	}

	// Collects data from user to update and existing flight
	private void updateFlight() throws SQLException {
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

		AdminService aserv = new AdminService();
		aserv.updateFlight(flight);

		return;
	}

	// Collects data from user to delete and existing flight
	private void deleteFlight() throws SQLException {
		System.out.println("Delete Flight");

		Flight flight = new Flight();

		System.out.println("Enter Flight ID:");
		flight.setFlightID(this.scan.nextLine());

		AdminService aserv = new AdminService();
		aserv.deleteFlight(flight);

		return;
	}

	// Shows flight table values
	private void readFlight() throws SQLException {
		System.out.println("Read Flights");

		AdminService aserv = new AdminService();
		aserv.readFlight();

		return;
	}

	private void crudPassengers() throws SQLException {
		System.out.println("Add/Update/Delete/Read Passengers");
		while (true) {
			System.out.println("1) Add");
			System.out.println("2) Update");
			System.out.println("3) Delete");
			System.out.println("4) Read");
			System.out.println("5) Quit to previous");

			String input = this.scan.nextLine();

			if (input.equals("1")) {
				addPassenger();
			} else if (input.equals("2")) {
				updatePassenger();
			} else if (input.equals("3")) {
				deletePassenger();
			} else if (input.equals("4")) {
				readPassenger();
			} else if (input.equals("5")) {
				return;
			} else {
				System.out.println("Incorrect input.\n");
			}
		}

	}

	// Collects data from user to create a new passenger
	private void addPassenger() throws SQLException {
		System.out.println("Add Passenger");

		Passenger passenger = new Passenger();

		System.out.println("Enter Booking ID:");
		passenger.setBookingId(this.scan.nextLine());

		System.out.println("Enter Given Name:");
		passenger.setGivenName(this.scan.nextLine());

		System.out.println("Enter Family Name:");
		passenger.setFamilyName(this.scan.nextLine());

		System.out.println("Enter Date of Birth: xxxx/xx/xx");
		passenger.setDob(this.scan.nextLine());

		System.out.println("Enter Gender: X");
		passenger.setGender(this.scan.nextLine());

		System.out.println("Enter Address:");
		passenger.setAddress(this.scan.nextLine());

		AdminService aserv = new AdminService();
		aserv.addPassenger(passenger);

		return;
	}

	// Collects data from user to update and existing passenger
	private void updatePassenger() throws SQLException {
		System.out.println("Update Passenger");

		Passenger passenger = new Passenger();

		System.out.println("Enter ID:");
		passenger.setId(this.scan.nextLine());

		System.out.println("Enter Booking ID:");
		passenger.setBookingId(this.scan.nextLine());

		System.out.println("Enter Given Name:");
		passenger.setGivenName(this.scan.nextLine());

		System.out.println("Enter Family Name:");
		passenger.setFamilyName(this.scan.nextLine());

		System.out.println("Enter Date of Birth: xxxx/xx/xx");
		passenger.setDob(this.scan.nextLine());

		System.out.println("Enter Gender: X");
		passenger.setGender(this.scan.nextLine());

		System.out.println("Enter Address:");
		passenger.setAddress(this.scan.nextLine());

		AdminService aserv = new AdminService();
		aserv.updatePassenger(passenger);

		return;
	}

	// Collects data from user to delete and existing passenger
	private void deletePassenger() throws SQLException {
		System.out.println("Delete Passenger");

		Passenger passenger = new Passenger();

		System.out.println("Enter Passenger ID:");
		passenger.setId(this.scan.nextLine());

		AdminService aserv = new AdminService();
		aserv.deletePassenger(passenger);

		return;
	}

	// Shows passenger table values
	private void readPassenger() throws SQLException {
		System.out.println("Read Passengers");

		AdminService aserv = new AdminService();
		aserv.readPassenger();

		return;
	}

	private void crudAirport() throws SQLException {
		System.out.println("Add/Update/Delete/Read Airports");
		while (true) {
			System.out.println("1) Add");
			System.out.println("2) Update");
			System.out.println("3) Delete");
			System.out.println("4) Read");
			System.out.println("5) Quit to previous");

			String input = this.scan.nextLine();

			if (input.equals("1")) {
				addAirport();
			} else if (input.equals("2")) {
				updateAirport();
			} else if (input.equals("3")) {
				deleteAirport();
			} else if (input.equals("4")) {
				readAirport();
			} else if (input.equals("5")) {
				return;
			} else {
				System.out.println("Incorrect input.\n");
			}
		}

	}

	// Collects data from user to create a new airport
	private void addAirport() throws SQLException {
		System.out.println("Add Airport");

		Airport airport = new Airport();

		System.out.println("Enter Airport Code: XXX");
		airport.setAirportCode(this.scan.nextLine());

		System.out.println("Enter City Name:");
		airport.setCity(this.scan.nextLine());

		AdminService aserv = new AdminService();
		aserv.addAirport(airport);

		return;
	}
	
	// Collects data from user to update and existing airport
		private void updateAirport() throws SQLException {
			System.out.println("Update Airport");

			Airport airport = new Airport();

			System.out.println("Enter Airport Code: XXX");
			airport.setAirportCode(this.scan.nextLine());

			System.out.println("Enter City Name:");
			airport.setCity(this.scan.nextLine());

			AdminService aserv = new AdminService();
			aserv.updateAirport(airport);

			return;
		}
		
		// Collects data from user to delete and existing airport
		private void deleteAirport() throws SQLException {
			System.out.println("Delete Airport");

			Airport airport = new Airport();

			System.out.println("Enter Airport Code: XXX");
			airport.setAirportCode(this.scan.nextLine());

			AdminService aserv = new AdminService();
			aserv.deleteAirport(airport);

			return;
		}
		
		// Shows airport table values
		private void readAirport() throws SQLException {
			System.out.println("Read Airports");

			AdminService aserv = new AdminService();
			aserv.readAirport();

			return;
		}
		
		private void ticketCancelationOverRide() throws SQLException {
			System.out.println("Over-ride Trip Cancellation");
			
			Booking booking = new Booking();
			
			AdminService aserv = new AdminService();
			aserv.readBooking();
			
			System.out.println("Enter ID of booking to over-ride:");
			booking.setId(this.scan.nextLine());
			
			aserv.updateBooking(booking);
			return;
		};

}
