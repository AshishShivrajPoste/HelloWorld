package com.aricent.edu.decorator;

public class MakePizza {

		public static void main(String[] args) {
			Pizza pizza = new TomatoSauce(new Mozaralla(new PlainPizza()));
			System.out.println("Descrition-->"+pizza.getDescription());
			System.out.println("Cost-->"+pizza.getCost());
		}
}
