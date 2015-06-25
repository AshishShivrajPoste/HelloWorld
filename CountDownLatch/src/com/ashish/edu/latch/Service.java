package com.ashish.edu.latch;

import java.util.concurrent.CountDownLatch;

public class Service  implements Runnable{

	private String serviceName;
	private long timeToRunService;
	private CountDownLatch latch;
	
	public Service(String serviceName,long timeToRunService,CountDownLatch latch){
		this.serviceName = serviceName;
		this.latch = latch;
		this.timeToRunService = timeToRunService;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(timeToRunService);
		} catch (InterruptedException e) {
			System.out.println("Thread "+serviceName+" Interrupted");
		}
		System.out.println("Service "+serviceName + " is Up");
		latch.countDown();
		
	}

	
}
