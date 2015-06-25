package com.ashish.edu.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RunnableBarrier implements Runnable {

	private CyclicBarrier cyclicBarrier1;
	private CyclicBarrier cyclicBarrier2;
	
	public RunnableBarrier(CyclicBarrier c1,CyclicBarrier c2){
		this.cyclicBarrier1 = c1;
		this.cyclicBarrier2 = c2;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " Waiting on cyclicBarrier1");
			this.cyclicBarrier1.await();
			
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " Waiting on cyclicBarrier2");
			this.cyclicBarrier2.await();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
