package com.aricent.edu.propery;
import java.io.*;
public class CandidateCode1 
{ 
    public static int colorSequences(String input1,String input2)
    {
        int m = input1.length();
        int n = input2.length();
        int[][] table = new int[m+1][n+1];
        if(input1.equalsIgnoreCase("")){
        	return n;
        }else if(input2.equalsIgnoreCase("")){
        	return m;
        }
        for(int j = 0; j <= n; j++){
        	table[0][j] = j;
        }
        for(int i = 0; i <= m; i++){
        	table[i][0] = i;
        }
        for(int i = 1; i <= m;i++){
        	for(int j = 1; j <= n;j++){
        		int left = table[i][j-1]+1;
        		int up = table[i-1][j]+ 1;
        		int diagonal = table[i-1][j-1] + checkChar(input1.charAt(i-1),input2.charAt(j-1));
        		table[i][j] = minimum(left,up,diagonal);
        	}
        }
        return table[m][n];
    }
    public static int checkChar(char a , char b){
    	return (a == b) ? 0 : 1;
    }
    public static int min(int a ,int b){
    	return (a <= b) ? a : b;
    }
    public static int minimum(int a , int b ,int c){
    	return min(min(a,b),c);
    }
    public static void main(String[] args) {
    	CandidateCode1 candidateCode = new CandidateCode1();
    	String input1 = new String("x");
    	String input2 = new String("sdfgh");
    	System.out.println(candidateCode.colorSequences(input1, input2));
	}
}