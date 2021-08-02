package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.dao.FlightBookingsDAO;
import com.ss.uto.dao.FlightDAO;
import com.ss.uto.dao.PassengerDAO;
import com.ss.uto.domain.Flight;
import com.ss.uto.domain.Passenger;

public class TravellerService {

	ConnectionUtil connUtil = new ConnectionUtil();

	public Passenger findPassenger(String enteredId) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			PassengerDAO pdao = new PassengerDAO(conn);

			List<Passenger> plist = pdao.findPassenger(enteredId);
			return plist.get(0);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}

	public void readFlight() throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			FlightDAO fdao = new FlightDAO(conn);

			List<Flight> flist = fdao.readFlight();

			for (Flight f : flist) {
				System.out.println(f.getFlightID() + " " + f.getRouteID() + " " + f.getAirplaneID()
						+ " " + f.getDepartureTime() + " " + f.getReservedSeats() + " " + f.getSeatPrice());
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void readBookedFlight(String passengerId) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			FlightDAO fdao = new FlightDAO(conn);

			List<Flight> flist = fdao.readBookedFlight(passengerId);

			for (Flight f : flist) {
				System.out.println(f.getFlightID() + " " + f.getRouteID() + " " + f.getAirplaneID()
						+ " " + f.getDepartureTime() + " " + f.getReservedSeats() + " " + f.getSeatPrice());
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void bookFlight(String flightId, Passenger passenger) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			FlightBookingsDAO fbdao = new FlightBookingsDAO(conn);
			fbdao.addBooking();
			String bookingId = fbdao.readBookingId().get(0).getId();
			fbdao.bookFlight(flightId, passenger, bookingId);
			
			System.out.println("Flight Booked!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void cancelFlight(String flightId, Passenger passenger) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			FlightBookingsDAO fbdao = new FlightBookingsDAO(conn);
			fbdao.cancelFlight(flightId, passenger);
			
			System.out.println("Flight Canceled!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
