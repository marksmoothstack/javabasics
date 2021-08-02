package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.dao.BookingDAO;
import com.ss.uto.dao.FlightDAO;
import com.ss.uto.dao.PassengerDAO;
import com.ss.uto.dao.RouteDAO;
import com.ss.uto.domain.Airport;
import com.ss.uto.domain.Booking;
import com.ss.uto.domain.Flight;
import com.ss.uto.domain.Passenger;
import com.ss.uto.domain.Route;

public class AdminService {

	// Create connection object
	ConnectionUtil connUtil = new ConnectionUtil();

	// Service method to add flight to database
	public void addFlight(Flight flight, Route route) throws SQLException {

		// Set connection variable
		Connection conn = null;

		// use try catch block to run individual database calls
		try {
			// Set connection with credentials
			conn = connUtil.getConnection();

			// Create database object to run SQL methods
			RouteDAO rdao = new RouteDAO(conn);

			// Place all collected route data objects into list for iteration
			List<Route> routeId = rdao.readRouteByAirportID(route.getOriginAirport(), route.getDestAirport());

			// Ensure empty list is not returned, return id value
			if (!routeId.get(0).getRouteId().equals(null)) {
				flight.setRouteID(routeId.get(0).getRouteId());
			} else {
				flight.setRouteID(rdao.addRoute(route).toString());
			}

			// Create database interaction object to add flight information
			FlightDAO fdao = new FlightDAO(conn);
			fdao.addFlight(flight);
			System.out.println("New Flight Created!");

			// Catch exceptions and roll back any changes made if exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when done
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Create update service method
	public void updateFlight(Flight flight) throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {
			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			FlightDAO fdao = new FlightDAO(conn);

			// Update flight with data from transfer object
			fdao.updateFlight(flight);
			System.out.println("Flight Updated!");

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Create delete service method
	public void deleteFlight(Flight flight) throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			FlightDAO fdao = new FlightDAO(conn);

			// Delete flight entry with corresponding value
			fdao.deleteFlight(flight);
			System.out.println("Flight Deleted!");

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Read flight method
	public void readFlight() throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			FlightDAO fdao = new FlightDAO(conn);

			// Create list of flight data objects
			List<Flight> flist = fdao.readFlight();

			// Iterate through list and display properties for user
			for (Flight f : flist) {
				System.out.println(f.getFlightID() + " " + f.getRouteID() + " " + f.getAirplaneID() + " "
						+ f.getDepartureTime() + " " + f.getReservedSeats() + " " + f.getSeatPrice());
			}

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Create passenger method
	public void addPassenger(Passenger passenger) throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			PassengerDAO pdao = new PassengerDAO(conn);

			// Pass data object to create new entry
			pdao.addPassenger(passenger);
			System.out.println("New Passenger Created!");

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Update method for passenger table
	public void updatePassenger(Passenger passenger) throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			PassengerDAO pdao = new PassengerDAO(conn);

			// Pass data object to update entry
			pdao.updatePassenger(passenger);
			System.out.println("Passenger Updated!");

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Delete method for passenger table
	public void deletePassenger(Passenger passenger) throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			PassengerDAO pdao = new PassengerDAO(conn);

			// Pass data object to update entry
			pdao.deletePassenger(passenger);
			System.out.println("Passenger Deleted!");

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Read method for passenger table
	public void readPassenger() throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			PassengerDAO pdao = new PassengerDAO(conn);

			// Create list of passenger data objects to iterate through for display
			List<Passenger> plist = pdao.readPassenger();

			// Iterate through passenger list and display the data fields
			for (Passenger p : plist) {
				System.out.println(p.getId() + " " + p.getBookingId() + " " + p.getGivenName() + " " + p.getFamilyName()
						+ " " + p.getDob() + " " + p.getGender() + " " + p.getAddress());
			}

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Insert method for airport table
	public void addAirport(Airport airport) throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			AirportDAO adao = new AirportDAO(conn);

			// Pass airport data object into database access method
			adao.addAirport(airport);
			System.out.println("New Airport Created!");

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Update method for airport table
	public void updateAirport(Airport airport) throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			AirportDAO adao = new AirportDAO(conn);

			// Pass airport data object into database access method
			adao.updateAirport(airport);
			System.out.println("Airport Updated!");

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Delete method for airport table
	public void deleteAirport(Airport airport) throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			AirportDAO adao = new AirportDAO(conn);

			// Pass airport data object into database access method
			adao.deleteAirport(airport);
			System.out.println("Airport Deleted!");

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Read method for airport table
	public void readAirport() throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			AirportDAO adao = new AirportDAO(conn);

			// Create list of airport data objects
			List<Airport> alist = adao.readAirport();

			// Iterate through list of data objects and display the data they contain
			for (Airport a : alist) {
				System.out.println(a.getAirportCode() + " " + a.getCity());
			}

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Read method for the booking table
	public void readBooking() throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			BookingDAO bdao = new BookingDAO(conn);

			// Create list of booking data objects
			List<Booking> blist = bdao.readBooking();

			// Iterate through list of data objects and display the data they contain
			for (Booking b : blist) {
				System.out.println(b.getId() + " " + b.getIsActive() + " " + b.getConfirmationCode());
			}

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	// Update method for booking table
	public void updateBooking(Booking booking) throws SQLException {

		// Initialize connection variable
		Connection conn = null;

		// Use try catch block to run individual database calls
		try {

			// Establish connection
			conn = connUtil.getConnection();

			// Create database access object
			BookingDAO bdao = new BookingDAO(conn);

			// Pass booking data object into database access method
			bdao.updateBooking(booking);
			System.out.println("Booking Over-ridden!");

			// Roll back changes made when exception is thrown
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();

			// Close connection when complete
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
