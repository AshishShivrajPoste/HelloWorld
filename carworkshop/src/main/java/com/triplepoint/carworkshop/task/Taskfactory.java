package com.triplepoint.carworkshop.task;

import com.triplepoint.carworkshop.constants.WorkShopConstants;
import com.triplepoint.carworkshop.util.PropertyReader;

public class Taskfactory {

	
	public static Task getTask(String taskName){
		PropertyReader propertyReader = PropertyReader.getInstance();
		Task task = null;
		if(taskName.equalsIgnoreCase(WorkShopConstants.CAR_PAINT)){
			Integer serviceTime = propertyReader.getPropertyInt(WorkShopConstants.CAR_PAINT+WorkShopConstants.SERVICE_TIME);
			Integer serviceFee = propertyReader.getPropertyInt(WorkShopConstants.CAR_PAINT+WorkShopConstants.SERVICE_FEE);
			task = new CarPaint(WorkShopConstants.CAR_PAINT, serviceFee, serviceTime);
		}else if(taskName.equalsIgnoreCase(WorkShopConstants.CAR_REPAIR)){
			Integer serviceTime = propertyReader.getPropertyInt(WorkShopConstants.CAR_REPAIR+WorkShopConstants.SERVICE_TIME);
			Integer serviceFee = propertyReader.getPropertyInt(WorkShopConstants.CAR_REPAIR+WorkShopConstants.SERVICE_FEE);
			task = new CarRepair(WorkShopConstants.CAR_REPAIR, serviceFee, serviceTime);
		}else if(taskName.equalsIgnoreCase(WorkShopConstants.CAR_WASH)){
			Integer serviceTime = propertyReader.getPropertyInt(WorkShopConstants.CAR_WASH+WorkShopConstants.SERVICE_TIME);
			Integer serviceFee = propertyReader.getPropertyInt(WorkShopConstants.CAR_WASH+WorkShopConstants.SERVICE_FEE);
			task = new CarWash(WorkShopConstants.CAR_WASH, serviceFee, serviceTime);
		}
		return task;
	}
}
