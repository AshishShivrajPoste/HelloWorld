package com.ashish.edu.producer;

import java.util.Vector;

import com.ashish.edu.test.KillerPoison;

public class Producer implements Runnable{

	private Vector<String> sharedResource;
	private int size;
	public Producer(Vector<String> sharedResource,int size){
		this.sharedResource = sharedResource;
		this.size  = size;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Produced "+ i +" --->");
			try {
				produce(i);
			} catch (InterruptedException e) {
				System.out.println("Thread is Interrupted-->"+Thread.currentThread().getName());
			}
		}
		try {
			produce(new KillerPoison());
		} catch (InterruptedException e) {
			System.out.println("Thread is Interrupted-->"+Thread.currentThread().getName());
		}
		System.out.println("Producer Finished");
		
		
	}
	private void produce(Object obj) throws InterruptedException {
		
		while(sharedResource.size() == size){
			synchronized (sharedResource) {
				System.out.println("sharedResource is Full,Producer is Blocked"+sharedResource.size());
				sharedResource.wait();
			}
		}
		synchronized (sharedResource) {
			sharedResource.add("produced"+obj);
			sharedResource.notifyAll();
		}
		
	}

	
}
