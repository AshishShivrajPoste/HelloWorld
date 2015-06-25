package com.aricent.edu.chain;

public class SubstractNumbers implements Chain {

	private Chain nextChain = null;
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void Calculate(Numbers number) {
		if(number.getOperation() == "sub"){
			System.out.println(number.getFirstNumber() + " - " +number.getSecondNumber() + " = " + (number.getFirstNumber() - number.getSecondNumber()) );
		}else{
			nextChain.Calculate(number);
		}
	}

}
