package com.aricent.edu.rod;

public class RodCutting {

	public int cut_Rod(int[] p , int n){
		
		if(n==0){
			return 0;
		}
		int q = (int) (-1.0/0);
		for(int i = 1;i <= n;i++){
			q = max(q,p[i]+cut_Rod(p, n-i));
		}
		return q;
		
	} 
	public int cut_Rod_Dynamic(int[] p , int n){
		int q = 0;
		int[] r = new int[n+1];
		r[0] = 0;
		if(n==0){
			return 0;
		}
		for(int j = 1;j <= n;j++){
			q = (int) (-1.0/0);
			for(int i=1;i<=j;i++){
				q = max(q,p[i]+r[j-i]);
			}
			
		}
		
		return q;
		
	}
	private int max(int q, int i) {
		if(q > i){
			return q;
		}else{
			return i;
		}
	}
	public static void main(String[] args) {
		int[] p = {0,1,5,8,9,10,17,17,20,24,30};
		RodCutting rodCutting = new RodCutting();
		Long startTime = System.nanoTime();
		System.out.println(rodCutting.cut_Rod(p,4));
		System.out.println("Time required1 -->"+(System.nanoTime()- startTime));
		
		Long startTime1 = System.nanoTime();
		System.out.println(rodCutting.cut_Rod_Dynamic(p,4));
		System.out.println("Time required2 -->"+(System.nanoTime()- startTime1));
	}
}
