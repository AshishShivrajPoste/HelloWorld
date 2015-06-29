package com.ashish.clonningdemo;

public class Employee implements Cloneable{

	private String empID;
	private Department department;
	
	public Employee(String empID,Department department){
		this.department  = department;
		this.empID = empID;
	}
	public Employee(){
		
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", department=" + department + "]";
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
