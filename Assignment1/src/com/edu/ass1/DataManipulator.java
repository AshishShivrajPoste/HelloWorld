package com.edu.ass1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * It is Data Manipulation class containing methods like (add,remove,search,sort,display).
 * @author bgh33493
 *
 */
public class DataManipulator {
	private List<Person> recordHolder;
	private static final int DEFAULT_ARRAY_SIZE = 16;
	private int currentSize = -1;
	private int listSize;
	public DataManipulator(){
		System.out.println("No Size Provided for Array,Setting it to Default size to 16");
		recordHolder = new ArrayList<Person>(DEFAULT_ARRAY_SIZE);
	}
	
	public DataManipulator(int size){
		recordHolder = new ArrayList<Person>(size);
		this.listSize = size;
	}
	/**
	 * This Method will the Person Record into Array if Array is 
	 * not full ,else will through an warning saying array is full
	 * @param person
	 */
	public void addRecord(){
		if(currentSize < this.listSize){
			Person person = null;
			try {
				person = DataUtility.getPersonInformation();
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentSize = currentSize + 1;
			if(person != null){
				recordHolder.add(person);
			}
		}else{
			System.out.println("Array is Full..you cant add more Person");
		}
	}
	

	/**
	 * Method will remove the Person record specified with the personId from Array 
	 * @param personId
	 */
	public void removeRecord(int personId){
		Person tempPerson = null;
		for(Person person : recordHolder){
			if(person.getPersonId() == personId){
				tempPerson = person;
			}
		}
		if(tempPerson != null){
			recordHolder.remove(tempPerson);
		}else{
			System.out.println("No such record Found");
		}
	}
	/**
	 * Method will search for a particular Person specified by personId
	 * @param personId
	 * @return
	 */
	public Person SearchRecord(int personId){
		Person tempPerson = null;
		for(Person person : recordHolder){
			if(person.getPersonId() == personId){
				tempPerson = person;
			}
		}
		if(tempPerson != null){
			return tempPerson;
		}else{
			System.out.println("No such record Found");
		}
		return null;
	}
	/**
	 * Display all the Person Records Present int Array
	 */
	public void displayRecords(){
		if(recordHolder.size()!=0){
			System.out.println("Records Found are:");
			for(Person person : recordHolder){
				System.out.println(person.toString());
			}
		}else{
			System.out.println("No Records Found!!!");
		}
		
	}
	/***
	 * It  will sort the List<Person> based on the Person ID 
	 */
	public void sortbyPersonId(){
		System.out.println("Sorted List by Person ID");
		Collections.sort(this.recordHolder, new SortbyPersonId());
		displayRecords();
	}
	/***
	 *  It  will sort the List<Person> based on the First Name
	 */
	public void sortbyFirstName(){
		System.out.println("Sorted List by First Name");
		Collections.sort(this.recordHolder, new SortByFirstName());
		displayRecords();
	}
	/**
	 *  It  will sort the List<Person> based on the Last Name
	 */
	public void sortbyLastName(){
		System.out.println("Sorted List by Last Name");
		Collections.sort(this.recordHolder, new SortByLastName());
		displayRecords();
	}
}
