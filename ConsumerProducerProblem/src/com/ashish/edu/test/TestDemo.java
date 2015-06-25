package com.ashish.edu.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.ashish.edu.consumer.ConsumerBlockingQueue;
import com.ashish.edu.producer.ProducerBlockingQueue;

public class TestDemo {

	
	
	public static void main(String[] args) {
		BlockingQueue<Object> blockingqueue =new ArrayBlockingQueue<Object>(5);
		Thread consumer = new Thread(new ConsumerBlockingQueue(blockingqueue));
		Thread producer = new Thread(new ProducerBlockingQueue(blockingqueue));
		
		
		
		try {
			consumer.start();
			producer.start();
			consumer.join();
			producer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
}
