package com.aricent.edu;

public class KMPAlgo {
	private String pattern =null;
	private String text = null;
	private int[] prefix = null;
	
	public KMPAlgo(String text,String pattern){
		this.pattern = pattern;
		this.text = text;
		prefix = new int[pattern.length()];
	}
	public int[] computePrefixFunction(){
		int m = pattern.length();
		int k = 0;
		prefix[0] = 0;
		for(int q = 1;q < m; q++){
			while(k > 0 && pattern.charAt(k) != pattern.charAt(q)){
				k = prefix[k];
			}
			if(pattern.charAt(k) == pattern.charAt(q))
			{
				k = k+1;
			}
			prefix[q] = k;
		}
		return prefix;
	}
	public void computeKMP(){
		int n = text.length();
		int m = pattern.length();
		int q = 0;
		prefix = computePrefixFunction();
		for(int i = 0;i < n; i++){
			while(q > 0 && pattern.charAt(q) != text.charAt(i)){
				q = prefix[q];
			}
			if(pattern.charAt(q) == text.charAt(i))
			{
				q = q+1;
			}
			if(q == m){
				System.out.println("substring start at index--->"+(i-m+1));
				q = prefix[q-1];
			}
			
		}
	}
	public static void main(String args[]){
		KMPAlgo kmpAlgo = new KMPAlgo("bacbababaababacabab", "aba");
		kmpAlgo.computeKMP();
		
	}
}
