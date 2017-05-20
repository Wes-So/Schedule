package com.schedule.core.entity;

public class Provider extends Person{
	
	private Business business;
	
	public Provider() {		
	}
	
	public Provider(String salutation, String firstName, String lastName, Business business) {
		super(salutation,firstName,lastName);
		this.business = business;
	}
	
	@Override
	public String toString(){
		String display = "--------------------------------------------------------------------------------------\r\n";
		display += "Provider Name: " + getSalutation()  + " " + getFirstName() + " " + getLastName() + "\r\n";
		display += "Phone: " + getContact().getNumber() +  "\r\n";
		display += "Email: " + getContact().getEmail() + "\r\n";
		display += "--------------------------------------------------------------------------------------\r\n";
		return display;		
	}

	

}
