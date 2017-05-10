package com.schedule.core.entity;

public class Provider extends Person{
	
	public Provider() {		
	}
	
	public Provider(String salutation, String firstName, String lastName) {
		super(salutation,firstName,lastName);
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
