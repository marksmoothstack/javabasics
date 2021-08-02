package com.ss.uto.domain;

public class Booking {

	private String id;
	private String isActive;
	private String confirmationCode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getConfirmationCode() {
		return confirmationCode;
	}
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
}
