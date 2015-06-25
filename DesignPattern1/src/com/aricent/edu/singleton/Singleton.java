package com.aricent.edu.singleton;

public class Singleton {

	private static Singleton singletonInstance = null;
	
	private Singleton(){};
	
	public static Singleton getInstance(){
		if(singletonInstance == null){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			synchronized (Singleton.class) {
				if(singletonInstance == null){
					singletonInstance = new Singleton();
				}
			}
		}
		return singletonInstance;
	}
}
