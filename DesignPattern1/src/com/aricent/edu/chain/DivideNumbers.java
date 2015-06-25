package com.aricent.edu.chain;

public class DivideNumbers implements Chain{

	private Chain nextChain = null;
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void Calculate(Numbers number) {
		if(number.getOperation() == "div"){
			System.out.println(number.getFirstNumber() + " / " +number.getSecondNumber() + " = " + (number.getFirstNumber() / number.getSecondNumber()));
		}else{
			System.out.println("Chain works only for add / sub / div / mul");
		}
	}
	
}
