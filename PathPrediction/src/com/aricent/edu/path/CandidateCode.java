package com.aricent.edu.path;

public class CandidateCode {
	private static int noofpaths = 0;
	private static int m;
	private static int n;
	public static int pathFinding(int[][] input,int i,int j){
			
		if(i >= m || j >= n){
			return -1;
		}
		if(i == m-1  && j == n-1 ){
			return noofpaths++; 
		}
	    if(input[i][j] == 1){
			pathFinding(input, i, j+1); 
		}
		else if(input[i][j] == 2){
			pathFinding(input, i+1, j); 
		}
		else if(input[i][j] == 3){
			pathFinding(input, i+1, j+1); 
		}	
		else if(input[i][j] == 4){
			pathFinding(input, i, j+1); 
			pathFinding(input, i+1, j); 
		}
		else if(input[i][j] == 5){
			pathFinding(input, i, j+1);
			pathFinding(input, i+1, j+1); 
		}
		else if(input[i][j] == 6){
			pathFinding(input, i+1, j); 
			pathFinding(input, i+1, j+1); 
		}
		else if(input[i][j] == 7){
			pathFinding(input, i, j+1); 
			pathFinding(input, i+1, j); 
			pathFinding(input, i+1, j+1); 
		}
		return noofpaths;
	}
	public static void main(String[] args) {
//		int noofpaths = 0;
//		int[][] input = new int[1][1];
		int[] input1 = {5,5};
		int[] input2 = {1,3,0,0,0,0,0,0,4,5,1,0,0,0,3,6,7,6,4,0,0,0,5,0,3,4,5,6,1};
//		int[] input2  = {1,2,3,0,0,3,4,6,0,2,0,2,1,3,2,4,6,0,0,3,0,1,2,3,4};
//		PathPrediction pathPrediction = new PathPrediction();
		System.out.println(CandidateCode.numberOfPath(input1, input2));
	}
	
	
	 public static int numberOfPath(int[] input1,int[] input2)
	 {
		m = input1[0];
		n = input1[1];
		 int[][] matrix = new int[m][n];
		 int z = 0;
		 for(int i = 0 ; i < m; i++){
			 for (int j = 0; j < n; j++) {
				matrix[i][j] = input2[z];
				z++;
			}
		 }
		return  pathFinding(matrix, 0, 0);
	 }
	 
	 
}
