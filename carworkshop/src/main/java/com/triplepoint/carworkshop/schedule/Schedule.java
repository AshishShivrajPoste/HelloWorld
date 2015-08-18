package com.triplepoint.carworkshop.schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule {

	private Date scheduleDate;
	private List<TaskAssignment> listOfTaskAssignment;
	
	public Schedule(){
		this.scheduleDate = scheduleDate;
		this.listOfTaskAssignment = new ArrayList<TaskAssignment>();
	}
	
	public Schedule(Date scheduleDate,List<TaskAssignment> listOfTaskAssignment){
		this.scheduleDate = scheduleDate;
		this.listOfTaskAssignment = new ArrayList<TaskAssignment>();
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public List<TaskAssignment> getListOfTaskAssignment() {
		return listOfTaskAssignment;
	}

	public void setListOfTaskAssignment(List<TaskAssignment> listOfTaskAssignment) {
		this.listOfTaskAssignment = listOfTaskAssignment;
	}
	
	public void addTaskAssignment(TaskAssignment taskAssignment){
		for(TaskAssignment assignment : listOfTaskAssignment){
			if(taskAssignment.getEmployee().getEmployeeID() == assignment.getEmployee().getEmployeeID()){
				assignment.setTaskassigned(taskAssignment.getTaskassigned());
				return;
			}
		}
		this.listOfTaskAssignment.add(taskAssignment);
		
	}
}
