package com.schedule.core.entity;

public class ContactInfo {
	private String number;
	private String email;
	

	public ContactInfo(String number, String email){
		this.number = number;
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

 
}
