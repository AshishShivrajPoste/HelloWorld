package com.aricent.edu.singleton;

public class MultipleThreadTest implements Runnable{

	
	private String name = null;
	public MultipleThreadTest(String name) {
		this.name = name;
	}
	@Override
	public void run(){
		Singleton firstInstance = Singleton.getInstance();
		System.out.println("firstInstance "+name+"--->"+System.identityHashCode(firstInstance));
	}
	public static void main(String[] args){
		Runnable t1 = new MultipleThreadTest("first");
		Runnable t2 = new MultipleThreadTest("Second");
		
		new Thread(t1).start();
		new Thread(t2).start();
	}
}
