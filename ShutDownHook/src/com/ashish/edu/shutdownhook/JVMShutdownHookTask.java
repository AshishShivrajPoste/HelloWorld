package com.ashish.edu.shutdownhook;

public class JVMShutdownHookTask extends Thread{

	@Override
	public void run() {
		System.out.println("JVM ShutDownHook Called:");
		System.out.println("Change Made");
	}
}
