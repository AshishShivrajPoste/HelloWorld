package com.aricent.edu.edit;

public class EditDistance {
	
	private static int[][] table = null;
	public int editDistance(String str1,String str2){
		int cost = 0;
		int m = str1.length();
		int n = str2.length();
		
		for(int i = 0; i <= m;i++)
		{
			table[i][0] = i; 
		}
		for(int j = 0; j <= n;j++)
		{
			table[0][j] = j; 
		}
		for(int i = 1;i <= m; i++){
			for(int j = 1; j <= n; j++){
				int leftValue = table[i][j-1] + 1;
				int topValue = table[i-1][j] + 1;
				int cornerValue = table[i-1][j-1];
				if(str1.charAt(i-1) != str2.charAt(j-1)){
					cornerValue = cornerValue + 1;
				}
				table[i][j] = minimum(leftValue,topValue,cornerValue);
			}
		}
		return table[m-1][n-1];
	}
	private int min(int a ,int b){
		return a < b ? a : b; 	
	}
	private int minimum(int a ,int b,int c){
		return min(min(a, b),c);
	}
	public static void main(String[] args) {
		String str1 = new String("X");
		String str2 = new String("trials");
		table = new int[str1.length()+1][str2.length()+1];
		EditDistance editDistance =  new EditDistance();
		System.out.println(editDistance.editDistance(str1, str2));
	}
}
