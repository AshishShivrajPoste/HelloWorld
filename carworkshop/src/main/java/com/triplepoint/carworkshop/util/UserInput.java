package com.triplepoint.carworkshop.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.triplepoint.carworkshop.constants.WorkShopConstants;
import com.triplepoint.carworkshop.employee.Employee;
import com.triplepoint.carworkshop.employee.EmployeeFactory;
import com.triplepoint.carworkshop.schedule.Schedule;
import com.triplepoint.carworkshop.schedule.TaskAssignment;
import com.triplepoint.carworkshop.task.Task;

public class UserInput {

	public static Schedule getScheduleInformation(List<Employee> workShopEmployees, List<Task> tasks){
		Scanner scanner = new Scanner(System.in);
		System.out.println("PREPARE SCHEDULE");
		String ans;
		String taskAns;
		Schedule schedule = new Schedule();
		do{
			//TaskAssignment taskAssignment = new TaskAssignment();
			System.out.println("AVALIABLE EMPLOYEES");
			printAvaliableEmployees(workShopEmployees);
			System.out.println("SELECT THE EMPLOYEE TO ASSIGN TASK BASED ON EMPLOYEE ID");
			Integer employeeID = scanner.nextInt(); 
			TaskAssignment taskAssignment = checkSchedule(schedule, employeeID);
			if(taskAssignment == null){
				taskAssignment = new TaskAssignment();
			}
			Employee employee = getEmployee(employeeID,workShopEmployees);
			taskAssignment.setEmployee(employee);
			System.out.println("ASSIGN TASK TO EMPLOYEE:"+employee);
			do{
				System.out.println("AVALIABLE TASKS");
				printAvaliableTasks(tasks);
				System.out.println("SELECT TASK TO ASSIGN EMPLOYEE "+employee.getEmployeeName() +" BASED ON TASK ID");
				Integer taskID = Integer.parseInt(scanner.next());
				Task task = getTask(taskID,tasks);
				taskAssignment.addTasks(task);
				System.out.println("DO YOU WANT TO ADD MORE TASK(Y/N)?");
				taskAns =  scanner.next();
			}while(taskAns.equalsIgnoreCase("Y"));
			schedule.addTaskAssignment(taskAssignment);
			schedule.setScheduleDate(Calendar.getInstance().getTime());
			System.out.println("DO YOU WANT TO ADD MORE SCHEDULE(Y/N)?");
			ans =  scanner.next();
		}while(ans.equalsIgnoreCase("y"));
		scanner.close();
		return schedule;
	}
	private static TaskAssignment checkSchedule(Schedule schedule,Integer empID){
		List<TaskAssignment> assignments = schedule.getListOfTaskAssignment();
		for(TaskAssignment assignment : assignments){
			if(assignment.getEmployee().getEmployeeID() == empID){
				return assignment;
			}
		}
		return null;
	}
	private static void printAvaliableEmployees(List<Employee> workShopEmployees){
		for (Employee employee : workShopEmployees) {
			System.out.println("EMPLOYEE ID : "+employee.getEmployeeID()+" EMPLOYEE NAME : "+employee.getEmployeeName());
		}
	}
	private static void printAvaliableTasks( List<Task> tasks){
		for (Task task : tasks) {
			System.out.println("TASK ID : "+task.getTaskID()+" TASK NAME : "+task.getTaskName());
		}
	}
	private static Employee getEmployee(Integer empID, List<Employee> workShopEmployees){
		for(Employee employee : workShopEmployees){
			if(employee.getEmployeeID() == empID){
				return employee;
			}
		}
		return null;
	}
	private static Task getTask(Integer taskID, List<Task> tasks){
		for(Task task : tasks){
			if(task.getTaskID() == taskID){
				return task;
			}
		}
		return null;
	}
	
	public static List<Employee> getEmployeeInfo(){
		Scanner scanner = new Scanner(System.in);
		List<Employee> listofemEmployees = new ArrayList<>();
		System.out.println("ADD EMPLOYEES TO WORKSHOP");
		String designation = PropertyReader.getInstance().getPropertyString(WorkShopConstants.EMPLOYEE_DESIGNATION);
		StringTokenizer stringTokenizer = new StringTokenizer(designation, ",");
		List<String> designationList = new ArrayList<String>();
		while(stringTokenizer.hasMoreTokens()){
			designationList.add(stringTokenizer.nextToken());
		}
		String ans = null;
		do{

			System.out.println("Enter Employee Name");
			String empName = scanner.next();
			System.out.println("TYPE OF EMPLOYEES AVALIABLE");
			Integer count = 0;
			for(String desig : designationList){
				count++;
				System.out.println("Press "+count+":"+desig);
			}
			System.out.println("Enter you choice");
			int choice = scanner.nextInt();
			Employee employee = EmployeeFactory.getEmployee(designationList.get(choice-1), empName);
		//	this.carWorkShop.addEmployee(employee);
			listofemEmployees.add(employee);
			System.out.println("DO YOU WANT MORE EMPLOYEES(Y?N)");
			ans = scanner.next();
		}while(ans.equalsIgnoreCase("y"));
	//	scanner.close();
		return listofemEmployees;
	}
	
}
