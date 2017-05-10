package com.schedule.core.entity;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String salutation;
	private String firstName;
	private String lastName;
	private ContactInfo contact;
	List<Schedule> schedules = new ArrayList<>();

	public Person() {
		super();
	}
	
	public Person(String salutation, String firstName, String lastName) {
		this.salutation = salutation;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setContactInfo(ContactInfo contact) {
		this.contact= contact;
		
	}

	public ContactInfo getContact() {		
		return contact;
	}

	public void removeContact() {
		contact = null;		
	}
	
	public void addSchedule(Schedule schedule){
		schedules.add(schedule);
	}
	
	public int getNumberOfSchedules(){
		return schedules.size();
	}

}