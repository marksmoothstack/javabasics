package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.domain.Airport;
import com.ss.uto.domain.Flight;

public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		while (rs.next()) {
			Flight a = new Flight();
			a.setFlightID(rs.getString("flight.id"));
			a.setRouteID(rs.getString("route_id"));
			a.setAirplaneID(rs.getString("airplane_id"));
			a.setDepartureTime(rs.getString("departure_time"));
			a.setReservedSeats(rs.getString("reserved_seats"));
			a.setSeatPrice(rs.getString("seat_price"));

			flights.add(a);
		}
		return flights;
	}

	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("INSERT INTO flight VALUES (?, ?, ?, ?, ?, ?)", new Object[] { null, flight.getRouteID(),
				flight.getAirplaneID(), flight.getDepartureTime(), flight.getReservedSeats(), flight.getSeatPrice() });
	}

	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("UPDATE flight SET route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? WHERE id = ?",
				new Object[] { flight.getRouteID(), flight.getAirplaneID(), flight.getDepartureTime(),
						flight.getReservedSeats(), flight.getSeatPrice(), flight.getFlightID() });
	}

	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("DELETE FROM flight WHERE id = ?", new Object[] { flight.getFlightID() });
	}

	public List<Flight> readFlight(Flight flight) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight WHERE id = ?", new Object[] { flight.getFlightID() });
	}
	
	public List<Flight> readBookedFlight(String passengerId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM passenger JOIN flight_bookings ON passenger.booking_id = flight_bookings.booking_id\r\n"
				+ "JOIN flight ON flight_bookings.flight_id = flight.id WHERE passenger.id = ?", new Object[] { passengerId });
	}
	
	public List<Flight> readFlight() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight", new Object[] {});
	}
}