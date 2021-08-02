package com.ss.uto.domain;

public class Flight {

	private String flightID;
	private String routeID;
	private String airplaneID;
	private String departureTime;
	private String reservedSeats;
	private String seatPrice;
	
	public String getFlightID() {
		return flightID;
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	public String getRouteID() {
		return routeID;
	}
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}
	public String getAirplaneID() {
		return airplaneID;
	}
	public void setAirplaneID(String airplaneID) {
		this.airplaneID = airplaneID;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(String reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public String getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(String seatPrice) {
		this.seatPrice = seatPrice;
	}	
}
