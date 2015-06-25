package com.aricent.edu.paranthesis;

public class Paranthesis_Version1 {

	private static int stringSize;
	public void printParenthesis(int n)
	{
		char[] character = new  char[stringSize]; 
		if(n > 0)
			calculatePossibleWellFormedParanthesis(0, n, 0, 0,character);
		return;
	}    

	private void calculatePossibleWellFormedParanthesis(int pos, int n, int open, int close, char[] character)
	{   

		if(close == n)
		{
			System.out.println(character);
			return;
		}
		else
		{
			if(open > close) {
				character[pos] = ')';
				char[] newArray = character.clone();
				calculatePossibleWellFormedParanthesis(pos+1, n, open, close+1,newArray);
			}
			if(open < n) {
				character[pos] = '(';
				char[] newArray = character.clone();
				calculatePossibleWellFormedParanthesis(pos+1, n, open+1, close,newArray);
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Paranthesis_Version1 paranthesis = new Paranthesis_Version1();
		System.out.println("All Possible Well formed paranthesis");
		/**Please provide the input below*/
		int input  = 4;
		stringSize = input*2;
		paranthesis.printParenthesis(input);

	}

}
