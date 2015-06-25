package com.ashish.edu.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee {


		private String name;
		private int age;
		private int sal;
		public Employee(){
		}
		public Employee(String name,int age,int sal){
			this.name = name;
			this.age = age;
			this.sal = sal;
		}
		public List<Employee> eliminateduplicateEmployees(List<Employee> list){
			Set<Employee> set = new HashSet<Employee>();
			for(Employee emp : list){
				set.add(emp);
			}
			return (List<Employee>)set;
		}
		
		public static void main(String[] args) {
			Employee e1 = new Employee("Ashish",27,30000);
			Employee e2 = new Employee("Ashish",27,30000);
			Employee e3 = new Employee("Sagar",27,40000);
			Employee e4 = new Employee("Vivek",25,30000);
			
			
			List<Employee> list = new ArrayList<Employee>();
			list.add(e1);
			list.add(e2);
			list.add(e3);
			list.add(e4);
			
			Employee emp =  new Employee();
			List<Employee> empList = emp.eliminateduplicateEmployees(list);
		}
}
