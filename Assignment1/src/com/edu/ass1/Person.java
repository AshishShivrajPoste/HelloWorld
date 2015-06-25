package com.edu.ass1;
/**
 * Its a POJO class (i.e bean) to hold the information related to a particular Person.
 * @author 
 *
 */
public class Person {

	private int personId;
	private String firstName;
	private String lastName;
	private String address;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "personId=" + personId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + "";
	}
	
	
}
