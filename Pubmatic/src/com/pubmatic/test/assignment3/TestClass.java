/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
package com.pubmatic.test.assignment3;

/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
	public static double totalP = 0;
	
    public static void main(String args[] ) throws Exception {
        // Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] array =  line.split(" ");
        double n = Double.parseDouble(array[0]);
        double p = Double.parseDouble(array[1]);
        double p1 = 1-(p/100);
        double p2 = p/100;
        rec(n, 1, p1, p2);
        System.out.println(totalP);
    }
    
    public static double rec(double n,double prob,double p1,double p2){
		if(n == 0){
			totalP = totalP+prob;
			return 1;
		}else if(n < 0){
			return 0;
		}
		else{
			return  rec(n-3, prob*p1,p1,p2) + rec(n-2, prob*p2,p1,p2);
		}
	}
}
