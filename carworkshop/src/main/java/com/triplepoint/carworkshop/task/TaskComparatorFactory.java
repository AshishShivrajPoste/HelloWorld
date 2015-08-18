package com.triplepoint.carworkshop.task;

import java.util.Comparator;

import com.triplepoint.carworkshop.schedule.Prioritization;

public class TaskComparatorFactory {

	public static Comparator<Task> getTaskComparator(Prioritization prioritization){
		Comparator<Task> comparator = null;
		if(prioritization == Prioritization.SERVICETIME){
			comparator = new TaskServiceTimeComparator();
		}else if(prioritization == Prioritization.SERVICEFEE){
			comparator = new TaskServiceFeeComparator();
		}
		return comparator;
	}
}
