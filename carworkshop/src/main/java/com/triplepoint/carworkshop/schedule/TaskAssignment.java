package com.triplepoint.carworkshop.schedule;

import java.util.ArrayList;
import java.util.List;

import com.triplepoint.carworkshop.employee.Employee;
import com.triplepoint.carworkshop.task.Task;

public class TaskAssignment {

	private Employee employee;
	private List<Task> taskassigned;
	
	public TaskAssignment(){
		
		this.taskassigned = new ArrayList<Task>();
	}
	public TaskAssignment(Employee employee, List<Task> taskassigned){
		this.employee = employee;
		this.taskassigned = new ArrayList<Task>();
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Task> getTaskassigned() {
		return taskassigned;
	}
	public void setTaskassigned(List<Task> taskassigned) {
		this.taskassigned = taskassigned;
	}
	
	public void addTasks(Task task){
		this.taskassigned.add(task);
	}
	
}
