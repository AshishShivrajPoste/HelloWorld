package com.aricent.edu.paranthesis;

public class Paranthesis_Version2 {

	private static int stringSize;
	public void printParenthesis(int n)
	{
		
		char[] character = new  char[stringSize]; 
		if(n > 0)
			character[0]  = '(';
		calculatePossibleWellFormedParanthesis(1, n, 1, 0,character);
		return;
	}    
	private void calculatePossibleWellFormedParanthesis(int pos, int n, int open, int close, char[] character)
	{   

		if(close == n && open == n)
		{
			System.out.println(character);
			return;
		}
		else
		{
			if(open >= close && pos < stringSize){

				char[] newArrayLeft = character.clone();
				char[] newArrayRight = character.clone();
				
				
				newArrayLeft[pos] = ')';
				calculatePossibleWellFormedParanthesis(pos+1, n, open, close+1,newArrayLeft);

				newArrayRight[pos] = '(';
				calculatePossibleWellFormedParanthesis(pos+1, n, open+1, close,newArrayRight);

			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Paranthesis_Version2 paranthesis = new Paranthesis_Version2();
		System.out.println("All Possible Well formed paranthesis");
		/**Please provide the input below*/
		int input  = 4;
		stringSize = input*2;
		paranthesis.printParenthesis(input);


	}

}
