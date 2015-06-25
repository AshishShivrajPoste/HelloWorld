package com.ashish.edu;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		
		Set<Student> setofStudents = new HashSet<Student>();
		Student s1 = new Student("John" ,"Doe");
		Student s2 = new Student("John" ,"Lincoln");
		Student s3 = new Student("Amy" ,"Doe");
		Student s4 = new Student("Foo" ,"Bar");
		
		setofStudents.add(s1);
		setofStudents.add(s2);
		setofStudents.add(s3);
		setofStudents.add(s4);
		
		
		System.out.println("Unique Students are");
		System.out.println(setofStudents);
	}
}
