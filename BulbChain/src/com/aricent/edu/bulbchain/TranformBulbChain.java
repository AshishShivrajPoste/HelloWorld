package com.aricent.edu.bulbchain;

	
	public class TranformBulbChain {
		private String chainofBulbs1 = null;
		private String chainofBulbs2 = null;
	
	public TranformBulbChain(String chainofBulbs1,String chainofBulbs2){
		this.chainofBulbs1 = chainofBulbs1;
		this.chainofBulbs2 = chainofBulbs2;
	}
	public int transform(int n ,int m){
		int corner;
		int left;
		int top;
		int[][] table =  new int[n+1][m+1];
		for(int i = 0;i <= n;i++){
			table[i][0] = i;
		}
		for(int j = 0;j <= m;j++){
			table[0][j] = j;
		}
		for(int i = 1; i <= n; i++){
			for(int j = 1;j <= m;j++){
				left = table[i][j-1]+1;
				top = table[i-1][j]+1;
				if(chainofBulbs1.charAt(i-1)!= chainofBulbs2.charAt(j-1)){
					corner = table[i-1][j-1] + 1;
				}else{
					corner = table[i-1][j-1];
				}
				table[i][j] = Minimum(left, top, corner);
			}
		}
		return table[n][m];
	}
	private int min(int a, int b) 
	{
		   return a < b ? a : b;
	}
	public int Minimum(int a, int b, int c)
	{
		   return min(min(a, b), c);
	}
	public static void main(String args[]){
		String s1 =new  String("x");
		String s2 =new  String("abcde");
		TranformBulbChain bulbChain = new TranformBulbChain(s1, s2);
		System.out.println(bulbChain.transform(s1.length(), s2.length()));
	}
}
