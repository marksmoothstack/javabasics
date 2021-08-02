package com.ss.uto.domain;

public class Route {

	private String routeId;
	private String originAirport;
	private String destAirport;

//	private List<Flight> flights;
	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	public String getDestAirport() {
		return destAirport;
	}

	public void setDestAirport(String destAirport) {
		this.destAirport = destAirport;
	}

}
