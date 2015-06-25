package com.edu.ass1;

import java.util.Comparator;
/***
 * This class will sort the List<Person> based on the First Name.
 * The class will Implement the Comparator Interface and overrides compare method of
 * Comparator Interface
 * @author 
 *
 */
public class SortByFirstName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
	}

}
