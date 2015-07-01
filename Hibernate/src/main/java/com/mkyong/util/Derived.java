package com.mkyong.util;

public class Derived extends Base{

	static{
		System.out.println("static1");
	}
	{
		System.out.println("static2");
	}
	public Derived(){
		System.out.println("Constructor");
	}
	public void f1(int x){
		System.out.println("Derived");
	}
	
	public static void main(String[] args) {
		int x = 0;
		Base base = new Derived();
		base.f1(x);
		
	}
}
