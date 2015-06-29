package com.ashish.clonningdemo;

public class Department {
	private String deptName;
	private Integer deptID;
	
	public Department(String deptName,Integer deptID){
		this.deptID = deptID;
		this.deptName=deptName;
	}
	public static void main(String[] args) {
		Department department = new Department("Sales", 121);
		Employee employee = new Employee("12", department);
		Employee employee2 = null;
		try {
			employee2 = (Employee) employee.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(employee);
		System.out.println(employee2);
		
		employee.setEmpID("13");
		
		System.out.println(employee);
		System.out.println(employee2);
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getDeptID() {
		return deptID;
	}
	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptID=" + deptID + "]";
	}
}
