package com.edu.stack.adt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		StackADT<String> stack = new BoundedStack<>(10);
		String ans = null;
		System.out.println("======================================================================================================");
		System.out.println("==================================== STACK ADT OPERATION =============================================");
		System.out.println("======================================================================================================");
		do{
			System.out.println("Press 1 to Push");
			System.out.println("Press 2 to Pop");
			System.out.println("Press 3 to Peep");
			int choice = 0;
			try {
				choice =Integer.parseInt(bufferReader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Wrong Choice Entered...Exiting");
				return;
			}
			switch(choice){
				case 1:
					System.out.println("Enter the String to add in Stack");
					String input = null;
					try {
						input = bufferReader.readLine();
					} catch (IOException e1) {
						System.out.println("IO Exception in getting the Input from Console");
						e1.printStackTrace();
					}
					stack.push(input);
					break;
				case 2:
					String output = stack.pop();
					if(output!=null){
						System.out.println("Popped Element is --> "+output);
					}
					break;
				case 3:
					String element = stack.peep();
					if(element!=null){
						System.out.println("Element on top of Stack is --> "+element);
					}
					break;
				default:
					System.out.println("Wrong choice entered..Try again");
				
			}
			System.out.println("Do you want to continue y/n");
			try {
				ans = bufferReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(ans.equalsIgnoreCase("y"));
		
	}

}
