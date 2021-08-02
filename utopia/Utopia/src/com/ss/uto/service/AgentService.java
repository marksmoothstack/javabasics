package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.dao.FlightDAO;
import com.ss.uto.dao.RouteDAO;
import com.ss.uto.domain.Flight;
import com.ss.uto.domain.Route;

public class AgentService {
	ConnectionUtil connUtil = new ConnectionUtil();

	public void readRoutes() throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			RouteDAO rdao = new RouteDAO(conn);

			List<Route> rlist = rdao.readRoute();

			int ii = 0;
			for (Route r : rlist) {
				ii++;
				System.out.println(ii + ") " + r.getOriginAirport() + " -> " + r.getDestAirport());
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

	public void readFlight() throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();

			FlightDAO fdao = new FlightDAO(conn);

			List<Flight> flist = fdao.readFlight();

			for (Flight f : flist) {
				System.out.println("Flight ID: " + f.getFlightID() + " | Departure Time: " + f.getDepartureTime()
						+ " | Reserved Seats: " + f.getReservedSeats() + " | Seat Price: " + f.getSeatPrice());
				
				break;
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
}
