package com.aricent.edu.cri.gl2;

import java.util.Timer;

public class FileLister implements Runnable{

	@Override
	public void run() {
		Timer timer = new Timer(true);
		InterruptTimerTask interruptTimerTask = new InterruptTimerTask(Thread.currentThread());
		timer.schedule(interruptTimerTask, 2000);
		try {
			// wait "waitTimeout" time period for getAvailableRPMFiles() to return
			getAvailableRPMFiles();
		} catch (InterruptedException e) {
		    System.out.println("timeout exeeded");
		} finally {
		    timer.cancel();
		    
		}
		System.out.println("Out of FileLister");
		
	}
	public void getAvailableRPMFiles () throws InterruptedException{
		Thread.currentThread().sleep(1000);
		
	}

	public static void main(String[] args) {
		FileLister fileLister =  new FileLister();
		Thread thread =  new Thread(fileLister);
		thread.start();
	}
}
