package com.simpleobjects;


public class PersonObject {
	String personId;
	String lastName;
	String firstName;
	String street;
	String city;
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String string) {
		this.personId = string;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		if (city.equalsIgnoreCase("City")) {
			this.city = "tested corectly";
		}	
		return city;
	}
}
