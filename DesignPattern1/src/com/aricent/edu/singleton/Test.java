package com.aricent.edu.singleton;

public class Test {

	public static void main(String[] args){
		
		Singleton firstInstance = Singleton.getInstance();
		System.out.println("firstInstance-->"+System.identityHashCode(firstInstance));
		Singleton secondInstance = Singleton.getInstance();
		System.out.println("secondInstance-->"+System.identityHashCode(secondInstance));
	}
}
