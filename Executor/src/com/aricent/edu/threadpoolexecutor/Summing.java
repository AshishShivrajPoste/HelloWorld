package com.aricent.edu.threadpoolexecutor;

public class Summing implements Runnable {

	private int value;
	public Summing(int value){
		this.value = value;
	}
	@Override
	public void run() {
		long sum = 0;
		for(int i = 1;i <= value;i++){
			sum = sum + i;
		}
		System.out.println("Sum for thread "+this.toString()+" is "+sum);
	}

	
}
