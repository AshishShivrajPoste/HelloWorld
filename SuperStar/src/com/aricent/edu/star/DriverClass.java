package com.aricent.edu.star;


import java.util.ArrayList;
import java.util.List;

public class DriverClass {

	private static  List<Person> listofPersons = new ArrayList<Person>();
	private static int i = -1;
	public Person findingSuperStar(Person p1,Person p2){
 		if(p2 ==null){
			return p1;
		}
 		if(p1 == null){
			return p2;
		}
		if((p1.knows(p2) && p2.knows(p1)) || ((!p1.knows(p2) && !p2.knows(p1)))){
			return findingSuperStar(getNextPerson(), getNextPerson());
		}else if(p1.knows(p2) && !p2.knows(p1)){
			return findingSuperStar(getNextPerson(), p2);
		}else if(p2.knows(p1) && !p1.knows(p2)){
			return findingSuperStar(p1, getNextPerson());
		}	
		return null;
	}
	public static void main(String[] args) {
		Person p1 =  new Person();
		Person p2 =  new Person();
		Person p3 =  new Person();
		Person p4 =  new Person();
		Person p5 =  new Person();
		Person p6 =  new Person();
		Person p7 =  new Person();
		Person p8 =  new Person();
		Person p9 =  new Person();
		Person p10 =  new Person();
		
		p1.setIsSuperStar(true);
		List<Person> list0 = new ArrayList<Person>();
		p1.setKnows(list0);
		
		
		
		List<Person> list1 = new ArrayList<Person>();
		list1.add(p1);
		p2.setKnows(list1);
		
		List<Person> list2 = new ArrayList<Person>();
		list2.add(p1);
		list2.add(p6);
		list2.add(p7);
		p3.setKnows(list2);
		
		List<Person> list3 = new ArrayList<Person>();
		list3.add(p1);
		list3.add(p2);
		p4.setKnows(list3);
		
		List<Person> list4 = new ArrayList<Person>();
		list4.add(p1);
		list4.add(p9);
		p5.setKnows(list4);
		
		List<Person> list5 = new ArrayList<Person>();
		list5.add(p1);
		list4.add(p6);
		list5.add(p2);
		p6.setKnows(list5);
		
		
		List<Person> list6 = new ArrayList<Person>();
		list6.add(p1);
		list6.add(p9);
		p7.setKnows(list6);
		
		List<Person> list7 = new ArrayList<Person>();
		list7.add(p1);
		list7.add(p2);
		list7.add(p5);
		p8.setKnows(list7);
		
		
		List<Person> list8 = new ArrayList<Person>();
		list8.add(p1);
		list8.add(p6);
		p9.setKnows(list8);
		
		List<Person> list9 = new ArrayList<Person>();
		list9.add(p1);
		list9.add(p8);
		p10.setKnows(list9);
		
		listofPersons.add(p5);
		listofPersons.add(p6);
		listofPersons.add(p7);
		listofPersons.add(p8);
		
		listofPersons.add(p2);
		listofPersons.add(p3);
		listofPersons.add(p4);
		listofPersons.add(p9);
		listofPersons.add(p10);
		listofPersons.add(p1);
		
		DriverClass driverClass =  new DriverClass();
		System.out.println(driverClass.findingSuperStar(getNextPerson(), getNextPerson()).getIsSuperStar());
	}
	
	public static Person getNextPerson(){
		i= i + 1;
		while(i < listofPersons.size()){
			return listofPersons.get(i);
		}
		return null;
	}
}
