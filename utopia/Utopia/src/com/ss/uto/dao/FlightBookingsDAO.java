package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.domain.Booking;
import com.ss.uto.domain.Passenger;

public class FlightBookingsDAO extends BaseDAO {

	public FlightBookingsDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> booking = new ArrayList<>();

		while (rs.next()) {
			Booking b = new Booking();
			b.setId(rs.getString("id"));
			b.setIsActive(rs.getString("is_active"));
			b.setConfirmationCode(rs.getString("confirmation_code"));

			booking.add(b);
		}

		return booking;
	}

	public List<Booking> readBookingId() throws ClassNotFoundException, SQLException {
		return read(
				"select * from booking where (id, is_active, is_active) in (select max(id), is_active, confirmation_code from booking group by id)",
				null);
	}

	public void addBooking() throws ClassNotFoundException, SQLException {
		save("insert into booking values (null, 1, '1234')", null);
	}

	public void bookFlight(String flightId, Passenger passenger, String bookingId)
			throws ClassNotFoundException, SQLException {
		bookFlightHelper(flightId, passenger, bookingId);
		save("insert into flight_bookings values (?, ?)",
				new Object[] { flightId, passenger.getBookingId() });
	}
	private void bookFlightHelper(String flightId, Passenger passenger, String bookingId) throws ClassNotFoundException, SQLException {
		save("update passenger set booking_id = ? where id = ?", new Object[] { bookingId, passenger.getId() });
	}
	
	public void cancelFlight(String flightId, Passenger passenger) throws ClassNotFoundException, SQLException {
		save("DELETE FROM flight_bookings WHERE flight_id = ? AND booking_id = ?", new Object[] { flightId, passenger.getBookingId() });
	}

}
