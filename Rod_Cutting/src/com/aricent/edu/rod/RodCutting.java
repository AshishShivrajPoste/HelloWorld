package com.aricent.edu.rod;

import java.util.Stack;

public class RodCutting {

	private static int[] r;
	private static int[] s;
	
	public int bottom_Up_Rod_Cutting(int[] p , int n){
		Stack st = new Stack();	
		st.push("1");
		r[0] = 0;
		for(int j = 1;j <= n;j++){
			int q = (int)(-1.0/0);
			for(int i = 1; i <= j;i++){
				if(q < p[i] + r[j - i]){
					q = p[i] + r[j - i];
					s[j] = i;
				}
			}
			r[j] = q;
		}
		return r[n];
	}
	public void print_Cut_Rod_Solution(int n){
		while(n > 0){
			System.out.println(s[n]);
			n = n - s[n];
		}
	}
	public static void main(String[] args) {
		int[] p = {0,1,5,8,9,10,17,17,20,24,30};
		int n = 8;
		r = new int[n+1];
		s = new int[n+1];
		RodCutting rodCutting = new RodCutting();
		System.out.println(rodCutting.bottom_Up_Rod_Cutting(p, n));
		rodCutting.print_Cut_Rod_Solution(n);
	}
}
