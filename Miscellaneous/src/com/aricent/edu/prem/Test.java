package com.aricent.edu.prem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		ashish as = new ashish();
		as.show();
		String s1 = new String("Ashish");
		String s2 = new String("Ashish");
		
		System.out.println("S1-->"+s1.hashCode());
		System.out.println("S2-->"+s2.hashCode());
		Map<String, String> m1 = new HashMap<String, String>();
	}
}
class ashish{
	
	Test test = new Test();
	public void show(){
		if(test instanceof Serializable){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
	
	
}