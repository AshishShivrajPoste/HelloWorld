package com.aricent.edu.cri.gl2;

import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

public class TaskDriver {

	private static  Map<Object, Object> loFileListerMap;
	
	private static TaskDriver driver = null;
	
	private TaskDriver(){}
	public void initoperation(){
		InterruptTimerTask loTimer = new InterruptTimerTask(loFileListerMap);
		Timer lo = new Timer();
		int plugAPITimerTask = 1000;
		lo.scheduleAtFixedRate(loTimer, 500, plugAPITimerTask);
		lo.schedule(loTimer,10000);
	}
	public static void main(String[] args) {
		TaskDriver driver = TaskDriver.getInstance();
		driver.initoperation();
		FileLister fileLister1 =  new FileLister();
		FileLister fileLister2 =  new FileLister();
		Thread thread1 =  new Thread(fileLister1,"Ashish");
		Thread thread2 =  new Thread(fileLister2,"Kannan");
		thread1.start();
		thread2.start();
		
	}
	public static TaskDriver getInstance() {
		if(driver == null){
			synchronized (TaskDriver.class) {
				if(driver == null){
					driver = new TaskDriver();
					loFileListerMap = new ConcurrentHashMap<Object,Object>();
				}
			}
		}
		return driver;
	}
	public static Map<Object, Object> getLoFileListerMap() {
		return loFileListerMap;
	}
	public static void setLoFileListerMap(Map<Object, Object> loFileListerMap) {
		TaskDriver.loFileListerMap = loFileListerMap;
	}
}
