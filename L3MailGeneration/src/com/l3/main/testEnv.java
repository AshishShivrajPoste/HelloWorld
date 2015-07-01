package com.l3.main;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class testEnv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name ="Itélé"; //example
		name = Normalizer.normalize(name, Normalizer.Form.NFD);   
		name = name.replaceAll("\\p{InCombiningDiacriticalMarks}+", ""); 

		
		System.out.println("mnbjkhkj:::"+name);

	}

}
