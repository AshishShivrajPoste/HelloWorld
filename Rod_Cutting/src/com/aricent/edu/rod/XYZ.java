package com.aricent.edu.rod;

import java.util.Stack;

public class XYZ {

	public  int[] mergeArrays(int[] a, int[] b) {
	    
		
		   
		
		
        int i  = a.length-1;
        int j = b.length -1;
        int size = a.length + b.length;
        int[] c = new int[size];
      
//        	  for(int k = 0 ; k <= size;k++){
        int k = 0;
        
        while(i != 1){
            if(!(a[i] >= a[i-1])){
                c[k] = -1;
                return c;
            }
            i--;
        }
        while(j != 1){
            if(!(a[j] >= a[j-1])){
                c[k] = -1;
                return c;
            }
            j--;
        }
        while(i != 1){
            if(!(a[i] >= a[i-1])){
                c[k] = -1;
                return c;
            }
        }
        		 while(i >= 0 && j >= 0){
                  if(a[i] >= b[j]){
                      c[k] = a[i];
                          i= i-1;
                      
                  }else{
                      c[k] = b[j];
                      j = j - 1;
                  }
                  k++;
//              }
        }
         
        return c;
        
       

}
	public static void main(String[] args) {
		int[] a = {1,3,2};
		int[] b = {2,5,6};
		XYZ xyz =  new XYZ();
		System.out.println(xyz.mergeArrays(a, b));
	}
}
