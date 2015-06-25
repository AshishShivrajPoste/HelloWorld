package com.arident.edu;

public class KMP {

	private String pattern = null;
	private String text = null;
	
	public KMP(){
		pattern =new String("ababaca");
		text = new String("bacbababaabcbab");
	}
	public int[] computePrefixFunction(){
		int m = pattern.length();
		int[] prefix  = new int[m];
		prefix[1] = 0;
		int k = 0;
		for(int q = 2;q <= m;q++){
			while(k>0 && pattern.charAt(k+1)!= pattern.charAt(q))
			{		
				k = prefix[k];
			}
			if(pattern.charAt(k+1) == pattern.charAt(q)){
				k = k+1;
			}
			prefix[q] = k;
		}
		return prefix;
	}
	public void KMP_matcher(){
		int n = text.length();
		int m = pattern.length();
		int[] prefix = computePrefixFunction();
		System.out.println(prefix);
		int q = 0;
		int i = 0;
		for(i = 0; i< n; i++){
			while(q > 0 && pattern.charAt(q+1) != pattern.charAt(i)){
				q = prefix[q];
			}
			if(pattern.charAt(q+1) == pattern.charAt(i)){
				q = q + 1;
			}
			if(q == m){
				System.out.println("Pattern occurs at-->"+(i-m));
			}
		}
		
	}
	public static void main(String args[]){
		KMP kmp = new KMP();
		kmp.KMP_matcher();
	}
}
