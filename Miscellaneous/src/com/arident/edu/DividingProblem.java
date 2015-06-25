package com.arident.edu;

import java.io.*;
public class DividingProblem 
{ 
    public static Boolean isSubset(int[] array,int n,int sum){
    	if(sum == 0){
    		return true;
    	}
    	if(n==0 && sum != 0){
    		return false;
    	}
    	if(array[n-1] > sum){
    		return isSubset(array,n-1,sum);
    	}
    	return (isSubset(array,n-1,sum) || isSubset(array,n-1,sum-array[n-1]));
    }
    public static String partition(int[] input1)
    {
        int sum = 0;
        for(int i = 0; i<input1.length;i++){
        	if(input1[i] >= 0){
        		sum += input1[i];
        	}else {
        		return "Invalid";
        	}
        }
        if(sum%2 == 0){
        	Boolean result = isSubset(input1,input1.length,sum);
        	if(result==true){
        		return "Yes";
        	}
        	else{
        		return "No";
        	}
        }
        else {
        	return "No";
        }
    }
    public static void main(String args[]){
    	int[] array = {3,1,5,9,12};
    	DividingProblem  dividingProblem = new DividingProblem();
    	dividingProblem.partition(array);
    }
}