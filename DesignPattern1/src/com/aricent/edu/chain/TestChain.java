package com.aricent.edu.chain;

public class TestChain {

	public static void main(String[] args){
		
		Chain addChain = new AddNumbers();
		Chain subChain = new SubstractNumbers();
		Chain mulChain = new MultipleNumbers();
		Chain divChain = new DivideNumbers();
		
		addChain.setNextChain(subChain);
		subChain.setNextChain(mulChain);
		mulChain.setNextChain(divChain);
		
		Numbers numbers = new Numbers(12, 6, "div");
		
		addChain.Calculate(numbers);
	}
}
