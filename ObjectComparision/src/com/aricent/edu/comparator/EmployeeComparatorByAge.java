package com.aricent.edu.comparator;

import java.util.Comparator;
import com.aricent.edu.comparble.Employee;
public class EmployeeComparatorByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getAge() > o2.getAge()){
			return 1;
		}else if(o1.getAge() < o2.getAge()){
			return -1;
		}else {
			return  0;
		}
	}
}
