package com.triplepoint.carworkshop;


import java.util.ArrayList;
import java.util.List;

import com.triplepoint.carworkshop.employee.Employee;
import com.triplepoint.carworkshop.schedule.Prioritization;
import com.triplepoint.carworkshop.schedule.Schedule;
import com.triplepoint.carworkshop.schedule.ScheduleExecutor;
import com.triplepoint.carworkshop.task.Task;
import com.triplepoint.carworkshop.util.UserInput;

public class CarWorkShop {

	private List<Employee> workShopEmployees;
	private List<Task> tasks;
	
	public CarWorkShop(){
		this.workShopEmployees = new ArrayList<Employee>();
		this.tasks = new ArrayList<Task>();
	}
	public Schedule prepareSchedule(){
		return UserInput.getScheduleInformation(workShopEmployees, tasks);
	}
	public void executeSchedule(Schedule schedule, Prioritization priority){
		ScheduleExecutor scheduleExecutor = new ScheduleExecutor(schedule, priority);
		scheduleExecutor.executeSchedule();
	}
	public void addEmployee(Employee emp){
		this.workShopEmployees.add(emp);
	}
	public Employee getEmployee(Integer empID){
		for(Employee employee : workShopEmployees){
			if(employee.getEmployeeID() == empID){
				return employee;
			}
		}
		return null;
	}
	public Task getTask(Integer taskID){
		for(Task task : tasks){
			if(task.getTaskID() == taskID){
				return task;
			}
		}
		return null;
	}
	public void addTask(Task task){
		this.tasks.add(task);
	}
	public List<Employee> getWorkShopEmployees() {
		return workShopEmployees;
	}
	public void setWorkShopEmployees(List<Employee> workShopEmployees) {
		if(workShopEmployees !=null){
			this.workShopEmployees = workShopEmployees;
		}	
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}
