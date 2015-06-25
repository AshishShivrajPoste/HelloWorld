package com.aricent.edu.comparble;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComparableTester {

		public static void main(String[] args) {
			List<Employee> employeeList = new ArrayList<Employee>();
			Employee emp1 = new Employee("Ashish", "Poste", 27, 27);
			Employee emp2 = new Employee("Prem", "Gupta", 27, 40);
			Employee emp3 = new Employee("Pravesha", "Jain", 26, 27);
			Employee emp4 = new Employee("Megha", "RM", 30, 60);
			employeeList.add(emp1);
			employeeList.add(emp2);
			employeeList.add(emp3);
			employeeList.add(emp4);
			System.out.println("Original List Before Sorting");
			printList(employeeList);
			Collections.sort(employeeList);
			System.out.println("List After Sorting");
			printList(employeeList);
			
		}
		public static void printList(List<Employee> employeeList){
			for(Employee employee : employeeList){
				System.out.println(employee.toString());
			}
		}
}
