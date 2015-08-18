package com.triplepoint.carworkshop;

import java.util.List;
import java.util.StringTokenizer;

import com.triplepoint.carworkshop.constants.WorkShopConstants;
import com.triplepoint.carworkshop.employee.Employee;
import com.triplepoint.carworkshop.schedule.Prioritization;
import com.triplepoint.carworkshop.schedule.Schedule;
import com.triplepoint.carworkshop.task.Task;
import com.triplepoint.carworkshop.task.Taskfactory;
import com.triplepoint.carworkshop.util.PropertyReader;
import com.triplepoint.carworkshop.util.UserInput;

public class CarWorkShopClient {

	private CarWorkShop carWorkShop;
	public CarWorkShopClient(){
		this.carWorkShop = new CarWorkShop();
		init();
	}
	
	public static void main(String[] args) {
		new CarWorkShopClient();
	}
	
	public void init(){
		initializeTasks();
		initializeEmployee();
		Schedule schedule= this.carWorkShop.prepareSchedule();
		String priority  = PropertyReader.getInstance().getPropertyString(WorkShopConstants.PRIORITIZATION);
		Prioritization prioritization = null;
		if(priority.equalsIgnoreCase(WorkShopConstants.PRIORITIZATION_SERVICE_FEE)){
			prioritization = Prioritization.SERVICEFEE;
		}else if(priority.equalsIgnoreCase(WorkShopConstants.PRIORITIZATION_SERVICE_TIME)){
			prioritization = Prioritization.SERVICETIME;
		}
		this.carWorkShop.executeSchedule(schedule, prioritization);
	}
	private void initializeTasks(){
		/**ADDING TASK TO CAR WORK SHOP*/
		PropertyReader propertyReader = PropertyReader.getInstance();
		String tasks = propertyReader.getPropertyString(WorkShopConstants.TASKS);
		StringTokenizer stringTokenizer = new StringTokenizer(tasks, ",");
		while(stringTokenizer.hasMoreTokens()){
			String taskName = stringTokenizer.nextToken();
			Task task = Taskfactory.getTask(taskName);
			this.carWorkShop.addTask(task);
		}
	}
	
	private void initializeEmployee(){
		List<Employee> listofEmployees = UserInput.getEmployeeInfo();
		this.carWorkShop.setWorkShopEmployees(listofEmployees);
	}
}
