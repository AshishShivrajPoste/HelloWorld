package com.ashish.edu.mario;

public class RoynMario {

	public static void main(String[] args) {
		RoynMario mario = new RoynMario();
		System.out.println("Solution-->"+mario.noofSolutions(2));
	}
	
	public int noofSolutions(int N){
		int sol[] = new int[N+1];
		sol[0] = 1;
		int sum =0;
		for(int i = 1; i <= N;i++){
			sum = 0;
			for(int j = 1; j <= i;j++){
				sum =sum + sol[i-j];
			}
			sol[i] = sum;
		}
		return sol[N];
	}
}
