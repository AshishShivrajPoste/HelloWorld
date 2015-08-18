package com.triplepoint.carworkshop.employee;

import com.triplepoint.carworkshop.constants.WorkShopConstants;

public class EmployeeFactory {

	public static Employee  getEmployee(String designation,String employeeName){
		Employee employee = null;
		if(designation.equalsIgnoreCase(WorkShopConstants.TRAINEE)){
			employee = new Trainee(employeeName);
		}else if(designation.equalsIgnoreCase(WorkShopConstants.EXPERT)){
			employee = new Expert(employeeName);
		}else if(designation.equalsIgnoreCase(WorkShopConstants.REGULAR_EMPLOYEE)){
			employee = new RegularEmployee(employeeName);
		}else if(designation.equalsIgnoreCase(WorkShopConstants.EMPLOYEE)){
			employee = new Employee(employeeName);
		}
		return employee;
	}
}
