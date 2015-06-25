package com.ashish.edu.consumer;

import java.util.Vector;

import com.ashish.edu.test.KillerPoison;

public class Consumer implements Runnable{

	private Vector<String> sharedResource;
	private int size;
	public Consumer(Vector<String> sharedResource,int size){
		this.sharedResource = sharedResource;
		this.size = size;
	}
	@Override
	public void run() {
		while(true){
			try {
				Object obj = consumed();
				if(obj instanceof KillerPoison){
					break;
				}
				
				System.out.println("consumed-->"+obj);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Thread Interrupted-->"+Thread.currentThread().getName());
			}
		}
		System.out.println("Consumer Finished");
	}
	private Object consumed() throws InterruptedException {
		
		while(sharedResource.isEmpty()){
			synchronized (sharedResource) {
				System.out.println("sharedResource is Empty,Consumer is Blocked-->"+sharedResource.size());
				sharedResource.wait();
			}
		}
		synchronized (sharedResource) {
			Object temp = sharedResource.remove(0);
			sharedResource.notifyAll();
			return temp;
		}
	}

	
}
