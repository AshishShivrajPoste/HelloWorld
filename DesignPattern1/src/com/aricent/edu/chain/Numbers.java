package com.aricent.edu.chain;


public class Numbers {

	private int firstNumber;
	private int secondNumber;
	private String operation = null;
	public Numbers(int firstNumber,int secondNumber,String operation){
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.operation = operation;
	}
	public int getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}
	public int getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
}
