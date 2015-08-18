package com.triplepoint.carworkshop.task;

public abstract class Task {

	protected Integer taskID;
	protected String taskName;
	protected Integer serviceFee;
	protected Integer serviceTime;
	private static Integer taskCount = 0;
	public Task(){}
	public Task(String taskName, Integer serviceFee, Integer serviceTime){
		this.serviceFee = serviceFee;
		this.taskName = taskName;
		this.serviceTime = serviceTime;
		taskCount = taskCount + 1;
		this.taskID = taskCount;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Integer getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Integer serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Integer getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(Integer serviceTime) {
		this.serviceTime = serviceTime;
	}
	public Integer getTaskID() {
		return taskID;
	}
	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}
	@Override
	public String toString() {
		return "TaskID=" + taskID + ", TaskName=" + taskName
				+ ", ServiceFee=" + serviceFee + ", ServiceTime=" + serviceTime
				+ "\n";
	}
	
}
