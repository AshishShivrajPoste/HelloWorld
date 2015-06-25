package com.edu.ass1;

import java.util.Comparator;
/**
 * This class will sort the List<Person> based on the Person ID.
 * The class will Implement the Comparator Interface and overrides compare method of
 * Comparator Interface
 * @author 
 *
 */
public class SortbyPersonId implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.getPersonId() > o2.getPersonId()){
			return 1;
		}else if(o1.getPersonId() < o2.getPersonId()){
			return -1;
		}else{
			return 0;
		}
	}

	
}
