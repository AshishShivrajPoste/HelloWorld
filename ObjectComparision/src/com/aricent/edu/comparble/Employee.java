package com.aricent.edu.comparble;

public class Employee implements Comparable<Employee>{

	private String name;
	private String lastName;
	private int age;
	private int salary;
	
	/**Default Constructor*/
	public Employee(){}
	
	/**Parameterized overloaded Constructor*/
	public Employee(String name,String lastName,int age,int salary){
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

//	@Override
//	public int compareTo(Employee employee) {
//		return this.getName().compareToIgnoreCase(employee.getName());
//	}
	@Override
	public int compareTo(Employee employee) {
		if(this.getAge() > employee.getAge()){
			return 1;
		}else if(this.getAge() < employee.getAge()){
			return -1;
		}else{
			return 0;
		}
	}
	@Override
	public String toString(){
		return "Employee{" + "Name="+name+" "+"LastName=="+lastName+" "+"Age=="+age+" "+"Salary=="+salary+"}";
	}
}
