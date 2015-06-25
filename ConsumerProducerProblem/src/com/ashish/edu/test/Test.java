package com.ashish.edu.test;

import java.util.Vector;

import com.ashish.edu.consumer.Consumer;
import com.ashish.edu.producer.Producer;

public class Test {

	
	public static void main(String[] args) {
		Vector<String> sharedResource = new Vector<String>();
		int size = 5;
		Consumer consumer = new Consumer(sharedResource,size);
		Producer producer =  new Producer(sharedResource, size);
		
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
