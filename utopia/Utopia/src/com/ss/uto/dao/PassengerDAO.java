package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.domain.Flight;
import com.ss.uto.domain.Passenger;

public class PassengerDAO extends BaseDAO<Passenger> {

	public PassengerDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		while (rs.next()) {
			Passenger a = new Passenger();
			a.setId(rs.getString("id"));
			a.setBookingId(rs.getString("booking_id"));
			a.setGivenName(rs.getString("given_name"));
			a.setFamilyName(rs.getString("family_name"));
			a.setDob(rs.getString("dob"));
			a.setGender(rs.getString("gender"));
			a.setAddress(rs.getString("address"));

			passengers.add(a);
		}
		return passengers;
	}

	public void addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("INSERT INTO passenger VALUES (?, ?, ?, ?, ?, ?, ?)",
				new Object[] { null, passenger.getBookingId(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDob(), passenger.getGender(), passenger.getAddress() });
	}

	public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("UPDATE passenger SET booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? WHERE id = ?",
				new Object[] { passenger.getBookingId(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDob(), passenger.getGender(), passenger.getAddress(), passenger.getId() });
	}

	public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("DELETE FROM passenger WHERE id = ?", new Object[] { passenger.getId() });
	}

	public List<Passenger> readPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM passenger WHERE id = ?", new Object[] { passenger.getId() });
	}
	
	public List<Passenger> findPassenger(String enteredId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM passenger WHERE id = ?", new Object[] { enteredId });
	}
	
	public List<Passenger> readPassenger() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM passenger", new Object[] {});
	}

}
