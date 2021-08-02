package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.domain.Flight;

public class FlightDAO extends BaseDAO<Flight> {

	// Connection method from BaseDAO
	public FlightDAO(Connection conn) {
		super(conn);
	}

	// Method to write objects to a generic list
	@Override
	public List extractData(ResultSet rs) throws ClassNotFoundException, SQLException {

		// Create object specific list
		List<Flight> flights = new ArrayList<>();

		// Iterate through collected data and apply to data transfer object
		while (rs.next()) {
			Flight a = new Flight();
			a.setFlightID(rs.getString("flight.id"));
			a.setRouteID(rs.getString("route_id"));
			a.setAirplaneID(rs.getString("airplane_id"));
			a.setDepartureTime(rs.getString("departure_time"));
			a.setReservedSeats(rs.getString("reserved_seats"));
			a.setSeatPrice(rs.getString("seat_price"));

			// Add filled objects to list
			flights.add(a);
		}

		// Return filled list
		return flights;
	}

	// Create a new row in flight with passed in data from data transfer object
	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("INSERT INTO flight VALUES (?, ?, ?, ?, ?, ?)", new Object[] { null, flight.getRouteID(),
				flight.getAirplaneID(), flight.getDepartureTime(), flight.getReservedSeats(), flight.getSeatPrice() });
	}

	// Update chosen flight row using passed in flight id
	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("UPDATE flight SET route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? WHERE id = ?",
				new Object[] { flight.getRouteID(), flight.getAirplaneID(), flight.getDepartureTime(),
						flight.getReservedSeats(), flight.getSeatPrice(), flight.getFlightID() });
	}

	// Delete chosen flight row using passed in flight id
	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("DELETE FROM flight WHERE id = ?", new Object[] { flight.getFlightID() });
	}

	// Return a list of flight data objects for rows with given id
	public List<Flight> readFlight(Flight flight) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight WHERE id = ?", new Object[] { flight.getFlightID() });
	}

	// Return a list of booked flights given a specific passenger id
	public List<Flight> readBookedFlight(String passengerId) throws ClassNotFoundException, SQLException {
		return read(
				"SELECT * FROM passenger JOIN flight_bookings ON passenger.booking_id = flight_bookings.booking_id\r\n"
						+ "JOIN flight ON flight_bookings.flight_id = flight.id WHERE passenger.id = ?",
				new Object[] { passengerId });
	}

	// Return a list of every row in the flight table
	public List<Flight> readFlight() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight", new Object[] {});
	}
}