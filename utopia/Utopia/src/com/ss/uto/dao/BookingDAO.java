package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.domain.Booking;

public class BookingDAO extends BaseDAO<Booking>{

	public BookingDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> bookings = new ArrayList<>();
		while (rs.next()) {
			Booking b = new Booking();
			b.setId(rs.getString("id"));
			b.setIsActive(rs.getString("is_active"));
			b.setConfirmationCode(rs.getString("confirmation_code"));
			bookings.add(b);
		}
		return bookings;
	}
	
	public List<Booking> readBooking() throws ClassNotFoundException, SQLException {
		return read("select * from booking where is_active = '0'", null);
	}
	
	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("update booking set is_active = '1' where id = ?",
				new Object[] { booking.getId() });
	}
}
