package com.aricent.edu.threads;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Running this Thread");
	}
	public void starting(){
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable);
		System.out.println(this);
		t1.start();
	}
}
