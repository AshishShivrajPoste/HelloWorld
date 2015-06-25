package com.arident.edu;

import java.io.*;
public class CandidateCode 
{ 
    public static int bitonic_sequence(int[] input1)
    {	
    	int n = input1.length;
    	int max = 0;
    	int[] inc = new int[n];
    	int[] dec = new int[n];
    	
    	inc[0] =  1;
    	dec[n-1] = 1;
    	
    	for(int i = 1;i < n; i++)
    	{
    		if(input1[i] >  input1[i-1]){
    			inc[i] = inc[i-1] + 1;
    		}
    		else{
    			inc[i] = inc[i-1];
    		}
    	}
    	for(int i = n-2;i >=0 ; i--)
    	{
    		if(input1[i] >  input1[i+1]){
    			dec[i] = dec[i+1] + 1;
    		}
    		else{
    			dec[i] = dec[i+1];
    		}
    	}
    	max = inc[0]+dec[0] - 1;
    	for(int i = 1;i<n;i++){
    		if((inc[i] + dec [i] - 1) > max){
    			max = inc[i] + dec[i] - 1;
    		}
    	}
    	return max;
    }
    public static void main(String[] args) {
    	CandidateCode candidateCode = new CandidateCode();
    	int[] input1 = {1,11,2,10,4,5,2,1};
    	System.out.println(candidateCode.bitonic_sequence(input1));
	}
}