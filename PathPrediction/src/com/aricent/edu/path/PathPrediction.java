package com.aricent.edu.path;

public class PathPrediction {

	int noofpaths = 0;
	public int pathFinding(int[][] input,int m,int n){
		if(m < 0 || n < 0){
			return -1;
		}
		if(m == 0  || n == 0 ){
			return noofpaths++; 
		}
		pathFinding(input, m-1, n-1); 
		pathFinding(input, m-1, n );
		pathFinding(input, m, n-1); 
		return noofpaths;
	}
	public static void main(String[] args) {
		int noofpaths = 0;
		int[][] input = new int[1][1];
		PathPrediction pathPrediction = new PathPrediction();
		System.out.println(pathPrediction.pathFinding(input, 1, 1));
	}
}
