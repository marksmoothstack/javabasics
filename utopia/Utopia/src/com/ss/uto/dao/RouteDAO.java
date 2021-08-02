/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.domain.Airport;
import com.ss.uto.domain.Flight;
import com.ss.uto.domain.Route;


public class RouteDAO extends BaseDAO {

	public RouteDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();
		while (rs.next()) {
			Route a = new Route();
			a.setRouteId(rs.getString("id"));
			a.setOriginAirport(rs.getString("origin_id"));
			a.setDestAirport(rs.getString("destination_id"));

			routes.add(a);
		}
		return routes;
	}
	
	public Integer addRoute(Route route) throws ClassNotFoundException, SQLException {
		return saveReturnPK("INSERT INTO route VALUES (?, ?, ?)", new Object[] { null, route.getOriginAirport(), route.getDestAirport()});
	}
	
	public List<Route> readRouteByAirportID(String origin, String destination) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM route WHERE origin_id = ? AND destination_id = ?", new Object[] { origin, destination });
	}
	
	public List<Route> readRoute() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM route", null);
	}
}
