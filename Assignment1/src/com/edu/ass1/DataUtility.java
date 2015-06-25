package com.edu.ass1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * It provide the utility Functionality like getting input from user.
 * @author 
 *
 */
public class DataUtility {
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static Person getPersonInformation() throws IOException {
		// TODO Auto-generated method stub
		Person person = new Person();
		System.out.println("Enter Person ID (Numerical)");
		String id = bufferedReader.readLine();
		int personId = Integer.parseInt(id);
		System.out.println("Enter Person FirstName");
		String firstName = bufferedReader.readLine();
		System.out.println("Enter Person LastName");
		String lastName = bufferedReader.readLine();
		System.out.println("Enter Person Address");
		String address = bufferedReader.readLine();
		
		person.setPersonId(personId);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddress(address);
		return person;
	}
	
	public static int getPersonIdfromUser(){
		System.out.println("Enter the ID of the person");
		String Id = null;
		try {
			Id = bufferedReader.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int personId = Integer.parseInt(Id);
		return personId;
	}
}
