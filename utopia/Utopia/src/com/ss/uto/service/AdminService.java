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

	ConnectionUtil connUtil = new ConnectionUtil();

	public void addFlight(Flight flight, Route route) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			RouteDAO rdao = new RouteDAO(conn);
			List<Route> routeId = rdao.readRouteByAirportID(route.getOriginAirport(), route.getDestAirport());
			if (!routeId.get(0).getRouteId().equals(null)) {
				flight.setRouteID(routeId.get(0).getRouteId());
			} else {
				flight.setRouteID(rdao.addRoute(route).toString());
			}

			FlightDAO fdao = new FlightDAO(conn);
			fdao.addFlight(flight);
			System.out.println("New Flight Created!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void updateFlight(Flight flight) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			FlightDAO fdao = new FlightDAO(conn);
			fdao.updateFlight(flight);
			System.out.println("Flight Updated!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deleteFlight(Flight flight) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			FlightDAO fdao = new FlightDAO(conn);
			fdao.deleteFlight(flight);
			System.out.println("Flight Deleted!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void readFlight() throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			FlightDAO fdao = new FlightDAO(conn);

			List<Flight> flist = fdao.readFlight();

			for (Flight f : flist) {
				System.out.println(f.getFlightID() + " " + f.getRouteID() + " " + f.getAirplaneID() + " "
						+ f.getDepartureTime() + " " + f.getReservedSeats() + " " + f.getSeatPrice());
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

	public void addPassenger(Passenger passenger) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.addPassenger(passenger);
			System.out.println("New Passenger Created!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void updatePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.updatePassenger(passenger);
			System.out.println("Passenger Updated!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deletePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.deletePassenger(passenger);
			System.out.println("Passenger Deleted!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void readPassenger() throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			PassengerDAO pdao = new PassengerDAO(conn);

			List<Passenger> plist = pdao.readPassenger();

			for (Passenger p : plist) {
				System.out.println(p.getId() + " " + p.getBookingId() + " " + p.getGivenName() + " " + p.getFamilyName()
						+ " " + p.getDob() + " " + p.getGender() + " " + p.getAddress());
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

	public void addAirport(Airport airport) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			AirportDAO adao = new AirportDAO(conn);
			adao.addAirport(airport);
			System.out.println("New Airport Created!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void updateAirport(Airport airport) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			AirportDAO adao = new AirportDAO(conn);
			adao.updateAirport(airport);
			System.out.println("Airport Updated!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deleteAirport(Airport airport) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			AirportDAO adao = new AirportDAO(conn);
			adao.deleteAirport(airport);
			System.out.println("Airport Deleted!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void readAirport() throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			AirportDAO adao = new AirportDAO(conn);

			List<Airport> alist = adao.readAirport();

			for (Airport a : alist) {
				System.out.println(a.getAirportCode() + " " + a.getCity());
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

	public void readBooking() throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			BookingDAO bdao = new BookingDAO(conn);

			List<Booking> blist = bdao.readBooking();

			for (Booking b : blist) {
				System.out.println(b.getId() + " " + b.getIsActive() + " " + b.getConfirmationCode());
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
	
	public void updateBooking(Booking booking) throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			BookingDAO bdao = new BookingDAO(conn);
			bdao.updateBooking(booking);
			System.out.println("Booking Over-ridden!");
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
