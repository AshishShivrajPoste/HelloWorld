package com.aricent.edu.signalling;

public class MyWaitNotify {

	private MyMonitredObject monitredObject;
	private boolean wasSignalled = false;
	public MyWaitNotify(MyMonitredObject monitredObject){
		this.monitredObject = monitredObject;
	}
	
	public void doWait(){
		synchronized (this) {
			if(!wasSignalled)
			{
				try {
					this.wait();
				} catch (InterruptedException e) {
					System.out.println("The Thread is Interrupted");
					e.printStackTrace();
				}
			}
			wasSignalled = false;
		}
		
	}
	public void doNotify(){
		synchronized (this) {
			wasSignalled = true;
			this.notifyAll();
		}
		
	}
}
