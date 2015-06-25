package com.aricent.edu.code.gladiator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class CandidateCode 
{ 
    public static String rollingdice(int[] input1,int[] input2)
    {
    	Map<Integer, Integer> map1 =  new HashMap();
    	Map<Integer, Integer> map2 =  new HashMap();
    	
    	
    	for(int i = 0 ; i < input1.length; i++){
    		Integer value = map1.get(input1[i]);
    		if(value != null){
    			value = value + 1;
    			map1.put(input1[i], value);
    		}else{
    			map1.put(input1[i], 1);
    		}
    	}
    	for(int i = 0 ; i < input2.length; i++){
    		Integer value = map2.get(input2[i]);
    		if(value != null){
    			value = value + 1;
    			map2.put(input2[i], value);
    		}else{
    			map2.put(input2[i], 1);
    		}
    	}   	
    	
    	
    	for (Integer it : map1.keySet()) {
    		Integer value1 = map1.get(it);
    		Integer value2 = map2.get(it);
    		map2.remove(it);
    		if(value1 != value2){
    			return "UnLucky";
    		}
		}
    	if(!map2.isEmpty()){
    		return "UnLucky";
    	}
		return "Lucky";
        //Write code here
    }
    public static void main(String[] args) {
    	CandidateCode candidateCode =  new CandidateCode();
    	int[] input1 = {12,11,5,7,11,12};
    	int[] input2 = {5,7,12,11,2,12,11};
    	System.out.println(candidateCode.rollingdice(input1, input2));
	}
}
