package com.pubmatic.test.assignment2;

public class StringManipulation {


	public String manipulateString(String input,int allowedconsecativechar){

		int inputStringSize = input.length();
		char currentChar = input.charAt(0);
		int counter = 1;
		int index = -1;
		char[] inputArray = input.toCharArray();
		for (int i = 1; i < inputStringSize; i++) {
			if(input.charAt(i)==currentChar){
				counter = counter+1;
				if(counter == allowedconsecativechar){
					replaceInputString(inputArray,index,input.subSequence(i-counter+1,i+1));
					index = index+allowedconsecativechar;
				}
			}else{
				currentChar = input.charAt(i);
				counter = 1;
				if(counter == allowedconsecativechar){
					replaceInputString(inputArray,index,input.subSequence(i-counter,i));
					index = index+counter;
				}
				
			}

		}
		//index = index+counter;
		String result = constructOutput(inputArray,index);
		return result;
	}
	private String constructOutput(char[] inputArray, int index) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i <= index; i++) {
			buffer.append(inputArray[i]);
		}
		return buffer.toString();
	}
	private void replaceInputString(char[] input, int index,CharSequence subSequence) {
		for (int i = 0; i < subSequence.length(); i++) {
			input[index+1] = subSequence.charAt(i);
			index++;
		}

	}
	public void manipulateString1(String input,int allowedconsecativechar){
		int counter = 0;
		char currentChar;
		char prevChar = input.charAt(0);
		for (int i = 0; i < input.length(); i++) {	
			currentChar = input.charAt(i);
			if(currentChar == prevChar){
				counter = counter +1;
			}else{
				counter=0;
				prevChar=currentChar;
			}
			if(counter <= allowedconsecativechar){
				System.out.print(currentChar);
			}
		}
	}

	public  String limitRepeatedCharacters(String string, int limit) {
		String processed = "";
		String result = "";
		if (!string.isEmpty() && !(limit < 1)) {
			// initialize with the first character
			char currentChar = string.charAt(0);
			int matches = 1;
			int index = 0;
			
			char[] inputArray = string.toCharArray();
			//processed = processed + currentChar;
			// go through the characters of the string one after another
			// starting at the 2nd characte
			for (int i = 1; i < string.length(); i++) {
				if (currentChar == string.charAt(i)) { // match found
					matches++;
					// add the same character if we have not yet reached the repetition limit
					if (matches <= limit) {
						//processed = processed + string.charAt(i);
						addcharAt(inputArray,index,string.charAt(i));
						index++;
					}
				} else { // new character encountered
					currentChar = string.charAt(i);
					matches = 1; //re-initialize number of matche
					//processed = processed + currentChar;
					addcharAt(inputArray,index,currentChar);
					index++;
				}
			}
			result = constructOutput(inputArray,index);
			
		}
		return result;
	//	return processed;
	}
	private static void addcharAt(char[] inputArray, int index, char charAt) {
		inputArray[index+1] = charAt;
	}
	public static void main(String[] args) {
		String input = "aaaaaaaaabbbcccdd";
		StringManipulation stringManipulation  =new  StringManipulation();
		System.out.println(stringManipulation.limitRepeatedCharacters(input, 2));
	}
}
