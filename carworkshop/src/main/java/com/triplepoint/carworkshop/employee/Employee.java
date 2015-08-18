package com.triplepoint.carworkshop.employee;


public class Employee {

	protected String employeeName;
	protected Integer employeeID;
	private static Integer employeeCount  = 0;
	public Employee(){}
	
	public Employee(String employeeName){
		this.employeeName = employeeName;
		employeeCount = employeeCount +1;
		this.employeeID = employeeCount;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "EmployeeName=" + employeeName + ", EmployeeID="
				+ employeeID + "\n";
	}
	
	
	
}
