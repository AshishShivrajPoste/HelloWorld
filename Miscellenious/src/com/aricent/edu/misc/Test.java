package com.aricent.edu.misc;

import java.util.Stack;

public class Test {
	
	private Boolean isValidParanthesis(String str){
		Stack<Character> stack = new Stack<Character>();
		for(int index = 0; index < str.length();index++){
			if(str.charAt(index) == '('){
				stack.push(str.charAt(index));
			}else if(str.charAt(index) == ')'){
				if(stack.isEmpty()){
					return false;
				}else{
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()){
			return true;
		}else {
			return false;	
		}
	}
	public static void main(String args[]){
		Test test = new Test();
		System.out.println(test.isValidParanthesis("()((abc)(xyz))"));
	}
}
