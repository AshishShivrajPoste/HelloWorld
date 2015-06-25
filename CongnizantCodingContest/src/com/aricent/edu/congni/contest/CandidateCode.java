package com.aricent.edu.congni.contest;

import java.io.*;
import java.util.StringTokenizer;

public class CandidateCode 
{ 
    public static int leastAmount(String[] input1)
    {
    	int col = 0;
    	int[][] matrix = new int[input1.length][];
        //Write code here
    	for(int i = 0; i < input1.length;i++){
    		StringTokenizer st2 = new StringTokenizer(input1[i], "#");
    		int[] row = new int[st2.countTokens()];
    		col = st2.countTokens();
    		int j = 0;
    		while (st2.hasMoreElements()) {
    			row[j] = Integer.parseInt(st2.nextToken());
    			j++;
    		}
    		matrix[i] = row;
    	}
    	
    	return leastAmount1(matrix,input1.length-1,col-1,0,0);
  
    }
    private static int leastAmount1(int[][] matrix, int length, int col,int m,int n) {
		if(m == length && n == col){
			return matrix[m][n];
		}
		if(m == length && n != col){
			return matrix[m][n] + leastAmount1(matrix, length, col, m, n+1);
		}
		if(n == col && m != length){
			return matrix[m][n] + leastAmount1(matrix, length, col, m+1, n);
		}
		int result = minimum(leastAmount1(matrix, length, col, m+1, n),leastAmount1(matrix, length, col, m, n+1));
		System.out.println("matrix[m][n] + result = "+ matrix[m][n] +"+" +result);
		return (matrix[m][n] + result);
	}
	private static int minimum(int leastAmount1, int leastAmount12) {
		if(leastAmount1 < leastAmount12){
			return leastAmount1;
		}else {
			return leastAmount12;
		}
	}
	
	
	 public static int leastAmount_improved(String[] input1)
	    {
	    	int col = 0;
	    	int[][] matrix = new int[input1.length][];
	        //Write code here
	    	for(int i = 0; i < input1.length;i++){
	    		StringTokenizer st2 = new StringTokenizer(input1[i], "#");
	    		int[] row = new int[st2.countTokens()];
	    		col = st2.countTokens();
	    		int j = 0;
	    		while (st2.hasMoreElements()) {
	    			row[j] = Integer.parseInt(st2.nextToken());
	    			j++;
	    		}
	    		matrix[i] = row;
	    	}
	    	int[][] result_Matrix = new int[input1.length][col];
	    	return leastAmount_improved1(matrix,input1.length-1,col-1,0,0,result_Matrix);
	  
	    }
	    private static int leastAmount_improved1(int[][] matrix, int length, int col,int m,int n,int[][] result_Matrix) {
	    	if(result_Matrix[m][n] != 0){
	    		return result_Matrix[m][n];
	    	}
			if(m == length && n == col){
				return matrix[m][n];
			}
			if(m == length && n != col){
				return matrix[m][n] + leastAmount_improved1(matrix, length, col, m, n+1,result_Matrix);
			}
			if(n == col && m != length){
				return matrix[m][n] + leastAmount_improved1(matrix, length, col, m+1, n,result_Matrix);
			}
			int result = minimum(leastAmount_improved1(matrix, length, col, m+1, n,result_Matrix),leastAmount_improved1(matrix, length, col, m, n+1,result_Matrix));
			System.out.println("matrix[m][n] + result = "+ matrix[m][n] +"+" +result);
			result_Matrix[m][n] =  matrix[m][n] + result;
			return (matrix[m][n] + result);
		}
	    
	public static void main(String[] args) {
    	CandidateCode candidateCode = new CandidateCode();
//    	String[] input1 = {"2#6#8#6#9","2#5#5#5#0","1#3#8#8#7","3#2#0#6#9","2#1#4#5#8","5#6#7#4#7"};
//    	String[] input1 = {"3#44#75","21#98#60"};
    	String[] input1 =  {"3#2#7","5#2#6","7#8#9"};
    	long startTime1 = System.nanoTime();
    	System.out.println(candidateCode.leastAmount(input1));
    	System.out.println("Complexity First-->"+(System.nanoTime() - startTime1));
    	
    	long startTime2 = System.nanoTime();
    	System.out.println(candidateCode.leastAmount_improved(input1));
    	System.out.println("Complexity Improved-->"+(System.nanoTime() - startTime2));
    
	}
}