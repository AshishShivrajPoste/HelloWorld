package com.arident.edu;

public class UnqiueChar {

	private static String first = "Hello";
	private static String second = "world";
	
	public static void main(String[] args) {
		
		boolean[]  bit = new boolean[256];
		for(int i = 0; i < second.length();i++){
			bit[second.charAt(i)] = true;
		}
		
		for(int i = 0; i < first.length();i++){
			if(bit[first.charAt(i)] == false){
				System.out.println(first.charAt(i));
			}
		}
	}
}
