package com.ashish.edu.barrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
		CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);
		
		RunnableBarrier runnableBarrier1 = new RunnableBarrier(cyclicBarrier1, cyclicBarrier2);
		RunnableBarrier runnableBarrier2 = new RunnableBarrier(cyclicBarrier1, cyclicBarrier2);
		RunnableBarrier runnableBarrier3 = new RunnableBarrier(cyclicBarrier1, cyclicBarrier2);
		
		Thread thread1 = new Thread(runnableBarrier1, "Thread1");
		Thread thread2 = new Thread(runnableBarrier2, "Thread2");
		Thread thread3 = new Thread(runnableBarrier3, "Thread3");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
