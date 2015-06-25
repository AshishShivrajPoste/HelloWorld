package com.edu.paranthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D_Small {

	private static char[] str;
	private static List<String> listofString;
	public String printParenthesis(int n,int k)
	{
	  if(n > 0)
	     _printParenthesis(0, n, 0, 0);
	  	int pos = (listofString.size() - k);
	  	if(pos < 0){
	  		return "Doesn't Exist!";
	  	}
	  return listofString.get(pos);
	} 
	void _printParenthesis(int pos, int n, int open, int close)
	{   
	 
	  if(close == n)
	  {
//	    System.out.println(str);
	    String temp = new String(str);
	    listofString.add(temp);
	    return;
	  }
	  else
	  {
	    if(open > close) {
	        str[pos] = '}';
	        _printParenthesis(pos+1, n, open, close+1);
	    }
	    if(open < n) {
	       str[pos] = '{';
	       _printParenthesis(pos+1, n, open+1, close);
	    }
	  }
	}
	public static void main(String[] args) {
		D_Small d_Small = new D_Small();
		
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		int[] narray = new int[testCases];
		int[] karray = new int[testCases];
		for(int i = 0; i < testCases;i++){
			narray[i] = scanner.nextInt();
			karray[i] = scanner.nextInt();
		}
		for(int i = 0; i < testCases;i++){
			listofString = new ArrayList<>();
			str = new char[narray[i]*2];
			String output = d_Small.printParenthesis(narray[i] ,karray[i]);
			System.out.println("Case #"+i +":  "+output);
		}
	}
}
