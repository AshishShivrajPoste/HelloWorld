package com.ashish.edu.latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] args) {
		CountDownLatch latch =  new CountDownLatch(3);
		
		Thread cacheService = new Thread(new Service("CacheService", 6000, latch));
		Thread validateService = new Thread(new Service("ValidateService", 2000, latch));
		Thread alerterService = new Thread(new Service("AlerterService", 5000, latch));
		
		cacheService.start();
		validateService.start();
		alerterService.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			System.out.println("Thread Waiting on CountDownLatch Interrupted");
		}
		System.out.println("Waiting Main Thread Started...");
	}
}
