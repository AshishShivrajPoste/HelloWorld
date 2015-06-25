package com.ashish.edu.producer;

import java.util.concurrent.BlockingQueue;

import com.ashish.edu.test.KillerPoison;

public class ProducerBlockingQueue implements Runnable{

	private BlockingQueue<Object> blockingQueue;
	
	public ProducerBlockingQueue( BlockingQueue<Object> blockingQueue){
		this.blockingQueue = blockingQueue;
	}
	@Override
	public void run() {
		
		for(int i = 0 ; i < 100;i++){
			Integer integer = new Integer(i);
			System.out.println(i+" Added into Queue");
//			try {
////				Thread.currentThread().sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			try {
				blockingQueue.put(integer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Poison Added");
		blockingQueue.offer(new KillerPoison());
	}

		
}
