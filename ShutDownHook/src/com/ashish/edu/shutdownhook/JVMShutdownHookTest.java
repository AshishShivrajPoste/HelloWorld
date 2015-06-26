package com.ashish.edu.shutdownhook;

public class JVMShutdownHookTest {

	public static void main(String[] args) {
		
		JVMShutdownHookTask hookTask = new JVMShutdownHookTask();
		System.out.println("In Main Method");
		Runtime.getRuntime().addShutdownHook(hookTask);
		System.out.println("ShutDownHook is Registered");
		Runtime.runFinalizersOnExit(true);
		System.exit(0);
		System.out.println("After Main Exits");
	}
	@Override
	protected void finalize() throws Throwable {
//		super.finalize();
		System.out.println("JVM finalize Called changed");
		super.finalize();
	}
}
