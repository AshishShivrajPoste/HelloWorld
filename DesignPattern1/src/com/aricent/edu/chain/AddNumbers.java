package com.aricent.edu.chain;

public class AddNumbers implements Chain{

	private Chain nextChian = null;
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChian = nextChain;
	}

	@Override
	public void Calculate(Numbers number) {
		if(number.getOperation() == "add"){
			System.out.println(number.getFirstNumber() + " + " +number.getSecondNumber() + " = " + (number.getFirstNumber() + number.getSecondNumber()));
		}else{
			nextChian.Calculate(number);
		}
	}
	
}
