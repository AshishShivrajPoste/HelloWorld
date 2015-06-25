package com.aricent.edu.signalling;

public class NotifyingThread implements Runnable{

	private MyWaitNotify myWaitNotify;
	
	public NotifyingThread(MyWaitNotify myWaitNotify){
		this.myWaitNotify = myWaitNotify;
	}
	
	@Override
	public void run() {
		System.out.println("In notify Thread-->"+Thread.currentThread().getName());
		myWaitNotify.doNotify();
		System.out.println("Notify is called from Thread-->"+Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		MyWaitNotify myWaitNotify = new MyWaitNotify(new MyMonitredObject());
		NotifyingThread notifyThread = new NotifyingThread(myWaitNotify);
		WaitingThread waitingThread = new WaitingThread(myWaitNotify);
		
		Thread t1 =  new Thread(notifyThread,"Notify Thread");
		Thread t2 = new Thread(waitingThread,"Waiting Thread1");
		Thread t3 = new Thread(waitingThread,"Waiting Thread2");
		Thread t4 = new Thread(waitingThread,"Waiting Thread3");
		Thread t5 = new Thread(waitingThread,"Waiting Thread4");
		
		t1.start();
		
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
	}
	
}
