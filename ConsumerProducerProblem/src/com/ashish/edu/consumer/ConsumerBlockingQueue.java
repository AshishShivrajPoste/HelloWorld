package com.ashish.edu.consumer;

import java.util.concurrent.BlockingQueue;

import com.ashish.edu.test.KillerPoison;

public class ConsumerBlockingQueue implements Runnable {

	private BlockingQueue<Object> blockingQueue;

	public ConsumerBlockingQueue(BlockingQueue<Object> blockingQueue){
		this.blockingQueue = blockingQueue;
	}
	@Override
	public void run() {
		
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			
			Object obj = null;
			try {
				obj = blockingQueue.take();
			} catch (InterruptedException e) {
				
			}
			if(obj instanceof KillerPoison){
				break;
			}
			System.out.println("Received-->"+obj);	

		}
		
	}
}
