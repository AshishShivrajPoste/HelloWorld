package com.triplepoint.carworkshop.task;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.triplepoint.carworkshop.schedule.Prioritization;
import com.triplepoint.carworkshop.schedule.TaskAssignment;

public class TaskExecutor implements Runnable{

	private TaskAssignment assignment;
	private Prioritization priority;
	private Map<String, List<Task>>  output;
	public TaskExecutor(TaskAssignment assignment,Prioritization priority,Map<String, List<Task>> output){
		this.assignment = assignment;
		this.priority = priority;
		this.output = output;
	}

	public void run() {
		List<Task> assignedTasks = assignment.getTaskassigned();
		if(assignedTasks == null || assignedTasks.size() == 0){
			System.out.println("NO ASSIGNED TASK FOR EMPLOYEE"+assignment.getEmployee().getEmployeeName());
			return;
		}
		Comparator<Task> taskPickerComparator = TaskComparatorFactory.getTaskComparator(priority);
		Collections.sort(assignedTasks, taskPickerComparator);
		Iterator<Task> ite = assignedTasks.iterator();
		Task task;
		output.put(assignment.getEmployee().getEmployeeName(), assignedTasks);
		while(ite.hasNext()){
			task = ite.next();
			System.out.println(assignment.getEmployee().getEmployeeName() + "\t\t"+ task.getTaskName() + "\t\t" + task.getServiceTime() + "\t\t" +task.getServiceFee());
		}
	}
	
}
