package com.aricent.edu.comparator;

import java.util.Comparator;

import com.aricent.edu.comparble.Employee;

public class EmployeeComparatorByName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}
	
}
