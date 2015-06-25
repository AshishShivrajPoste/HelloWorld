package com.aricent.com.lonestpalindrome;

public class LongestSubPalindrome {

	
	public int largestSubstringPalindrome(String inputString){
		int stringLength = inputString.length();
		boolean[][] table = new boolean[stringLength][stringLength];
		int startPoint = 0;
		int maxLength = 1;
		/*String of length 1*/
		for(int i = 0;i < stringLength; i++){
			table[i][i] = true;
		}
		for(int i = 0; i < stringLength-1;i++){
			if(inputString.charAt(i) == inputString.charAt(i+1)){
				table[i][i+1] = true;
				startPoint = i;
				maxLength = 2;
			}
		}
		/*SubString of length k*/
		for(int k = 3;k <= stringLength;k++){
			/**Setting the starting point*/
			for(int i = 0;i < stringLength - k + 1;i++){
				int j = i + k - 1;
				if(table[i+1][j-1] && inputString.charAt(i) == inputString.charAt(j)){
					table[i][j] = true;
					if(k > maxLength){
						maxLength  = k;
						startPoint = i;
					}
				}
			}
		}
		printSolution(inputString, startPoint,maxLength);
		return maxLength;
	}
	public void printSolution(String inputString,int startPoint,int maxLength){
		for(int i = startPoint; i < startPoint + maxLength;i++){
			System.out.print(inputString.charAt(i));
		}
	}
	public static void main(String[] args) {
		LongestSubPalindrome subPalindrome = new LongestSubPalindrome();
		String inputString = new String("dnitinw");
		System.out.println(subPalindrome.largestSubstringPalindrome(inputString));
	}
}
