package com.triplepoint.carworkshop.schedule;

import java.util.List;
import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.triplepoint.carworkshop.task.Task;
import com.triplepoint.carworkshop.task.TaskExecutor;

public class ScheduleExecutor {
	private Schedule schedule;
	private ExecutorService pool;
	private Prioritization priority;
	private Map<String, List<Task>> output;
	public ScheduleExecutor(){}
	public ScheduleExecutor(Schedule schedule,Prioritization priority){
		this.schedule = schedule;
		this.priority = priority;
		this.output = new ConcurrentHashMap<>();
		this.pool = Executors.newCachedThreadPool();
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public void executeSchedule(){
		List<TaskAssignment> listofAssigment = schedule.getListOfTaskAssignment();
		System.out.println("EXPECTED OUTPUT FOR DATE "+schedule.getScheduleDate());
		
		if(priority == Prioritization.SERVICEFEE){
			System.out.println("PRIORITIZATION :  SERVICE FEE" );
		}else if(priority == Prioritization.SERVICETIME){
			System.out.println("PRIORITIZATION : SERVICE TIME" );
		}
		System.out.println("EMPLOYEE NAME" + "\tTASK NAME"+ "\tSERVICE TIME"+"\tSERVICE FEE");
		for(TaskAssignment assignment : listofAssigment){
			TaskExecutor executor = new TaskExecutor(assignment, priority,output);
			pool.submit(executor);
		}
	}
}
