package com.aricent.alu;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void  main(String args[]) {
		Map<String, String> hash1 = new HashMap<>();
		
		hash1.put("15", "Ashish");
		hash1.put("12", "Megha");
		hash1.put("20", "Prem");
		hash1.put("30", "Pravesha");
	
		HashMapRedined<String, String> hash = new HashMapRedined<String,String>(10);
		hash.putModified("15", "Ashish");
		hash.putModified("12", "Megha");
		hash.putModified("20", "Prem");
		hash.putModified("30", "Pravesha");
		
		System.out.println(hash.getModified("12"));
	}
}
