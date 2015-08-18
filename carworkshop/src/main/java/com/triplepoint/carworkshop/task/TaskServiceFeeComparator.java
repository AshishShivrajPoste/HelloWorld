package com.triplepoint.carworkshop.task;

import java.util.Comparator;

public class TaskServiceFeeComparator implements Comparator<Task>{

	public int compare(Task firstTask, Task secondTask) {
	//	return secondTask.getServiceFee() - firstTask.getServiceFee();
		
		Integer fee1 = firstTask.getServiceFee();
	    Integer fee2 = secondTask.getServiceFee();
	    int compare = (int) Math.signum(fee1.compareTo(fee2));
	    	return compare * (-1);
	}
}
