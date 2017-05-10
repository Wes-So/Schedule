package com.schedule.core.entity;

import java.util.ArrayList;
import java.util.List;


public class Business {


	private String name;
	private String status;
	private final static String ACTIVE = "ACTIVE";
	private final static String INACTIVE = "INACTIVE";
	List<Provider> providers;
	Address address;

	public Business(String name, String status){
		this.name = name;
		this.status = status;
		providers = new ArrayList<>();
	}
	
	public Business(String name) {
		this(name,INACTIVE);
	}

	public Business(){
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void toggleStatus() {
		status = status.equals(ACTIVE) ? INACTIVE :ACTIVE;
	}

	public String getStatus() { 
		return status;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void addProvider(Provider provider) {
		providers.add(provider);		
	}

	public void removeProvider(Person provider) {
		providers.remove(provider);
	}
	 
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
//	@Override
//	public String toString(){
//		String display = "--------------------------------------------------------------------------------------\r\n";
//		display += "Business Name: " + name + "\r\n";
//		display += "Address: " + address.getAddress1() + " " + address.getState() + " " + address.getCity() + "\r\n";
//		display += "Total Number of Providers: " + providers.size() + "\r\n";
//		display += "--------------------------------------------------------------------------------------\r\n";
//		return display;
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Business other = (Business) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	


}
