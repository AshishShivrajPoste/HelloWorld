package com.mkyong.util;

public class Base {

	static{
		System.out.println("static 3");
	}
	{
		System.out.println("static 4");
	}
	public void f1(int x){
		System.out.println("Base"+x);
	}
}
