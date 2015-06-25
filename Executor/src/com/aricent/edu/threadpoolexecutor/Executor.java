package com.aricent.edu.threadpoolexecutor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor {

	private static ExecutorService threadPool = null;
	public static void main(String[] args) {
		Thread t1 = new Thread(new Summing(234));
		Thread t2 = new Thread(new Summing(347));
		Thread t3 = new Thread(new Summing(874));
		Thread t4 = new Thread(new Summing(2134));
		Thread t5 = new Thread(new Summing(4345));
		List<Future<?>> list = new ArrayList<>();
		threadPool = Executors.newCachedThreadPool();
		list.add(threadPool.submit(t1));
		list.add(threadPool.submit(t2));
		list.add(threadPool.submit(t3));
		list.add(threadPool.submit(t4));
		list.add(threadPool.submit(t5));
		int decrementCounter = list.size();
		Iterator<Future<?>> itr = list.iterator();
		while(itr.hasNext()){
			try {
				if(null == itr.next().get()){
					decrementCounter--;
					System.out.println("Task Remaining--->"+decrementCounter);
					itr.remove();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
