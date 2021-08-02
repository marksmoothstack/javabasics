package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.domain.Airport;


public class AirportDAO extends BaseDAO<Airport> {

	public AirportDAO(Connection conn) {
		super(conn);
	}

	public void addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("insert into airport VALUES (?, ?)", new Object[] { airport.getAirportCode(), airport.getCity() });
	}

	public void updateAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("update airport set city = ? where iata_id = ?",
				new Object[] { airport.getCity(), airport.getAirportCode() });
	}

	public void deleteAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("delete from airport where iata_id = ?", new Object[] { airport.getAirportCode() });
	}

	public List<Airport> readAirport() throws ClassNotFoundException, SQLException {
		return read("select * from airport", null);
	}

	public List<Airport> readAirportsByCityName(String cityName) throws ClassNotFoundException, SQLException {
		cityName = "%" + cityName + "%";
		return read("select * from airport where city like ?", new Object[] { cityName });
	}

	public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		while (rs.next()) {
			Airport a = new Airport();
			a.setAirportCode(rs.getString("iata_id"));
			a.setCity(rs.getString("city"));
			airports.add(a);
		}
		return airports;
	}

}
