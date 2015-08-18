package com.triplepoint.carworkshop.task;

import java.util.Comparator;

public class TaskServiceTimeComparator implements Comparator<Task>{

	public int compare(Task firstTask, Task secondTask) {
//		return secondTask.getServiceTime()-firstTask.getServiceTime();
		Integer time1 = firstTask.getServiceTime();
	    Integer time2 = secondTask.getServiceTime();
	    int compare = (int) Math.signum(time1.compareTo(time2));
	    	return compare * (-1);
	}

}
