package com.aricent.edu.signalling;

public class WaitingThread implements Runnable{

private MyWaitNotify myWaitNotify;
	
	public WaitingThread(MyWaitNotify myWaitNotify){
		this.myWaitNotify = myWaitNotify;
	}
	@Override
	public void run() {
		System.out.println("In waiting Thread-->"+Thread.currentThread().getName());
		myWaitNotify.doWait();	
		System.out.println("Waiting Thread " + Thread.currentThread().getName() + " is been Notified");
	}

}
