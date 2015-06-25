package com.aricent.edu.decorator;

public class Mozaralla extends ToppingDecorator{

	public Mozaralla(Pizza newPizza) {
		super(newPizza);
	}

	public String getDescription(){
		return tempPizza.getDescription() + ", Mozaralla";
	}
	public double getCost(){
		return tempPizza.getCost() + 0.30;
		
	}
		
}
