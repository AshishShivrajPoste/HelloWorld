package com.arident.edu;

public class MatrixSearch {

	private static int[][] matrix = {{1,5,6,8,9},
									{2,7,10,11,15},
									{3,12,20,23,25},
									{13,14,26,30,38},
									{31,36,40,43,50},
									{41,47,59,60,70}
									};
	private int row = 6;
	private int col = 5;
	
	public int kLargestElement(int k){
		int x = matrix[0][0];
		int y = matrix[row-1][col-1];
		while(y > (x+1)){
			int mid = (x+y)/2;
			int value  = largestRank(mid);
			if(value == k){
				return mid;
			}
			if(value > k){
				x = mid;
			}
			else if(value <= k){
				y = mid;
			}
		}
		if(x == y){
			return x;
		}
		if(y == x+1){
			if(largestRank(x) == k){
				return x;
			}
			else{
				return y;
			}
		}
		return -1;
	}
	
	public int kSmallestElement(int k){
		int x = matrix[0][0];
		int y = matrix[row-1][col-1];
		while(y > (x+1)){
			int mid = (x+y)/2;
			int value  = smallestRank(mid);
			if(value == k){
				return mid;
			}
			if(value <= k){
				x = mid;
			}
			else if(value > k){
				y = mid;
			}
		}
		if(x == y){
			return x;
		}
		if(y == x+1){
			if(smallestRank(x) == k){
				return x;
			}
			else{
				return y;
			}
		}
		return -1;
	}
	public int smallestRank(int number){
		int part1 = 0;
		int part2 = 0;
		int i = 0;
		int j = col-1;
		while(i < row && j>-1){
			if(matrix[i][j] <= number){
				part1 =part1 + (j+1);
				i++;
			}else{
				part2 = part2 + (row)-i;
				j--;
			}
		}
		return part1;
		
	}
	public int largestRank(int number){
		int part1 = 0;
		int part2 = 0;
		int i = 0;
		int j = col-1;
		while(i < row && j>-1){
			if(matrix[i][j] < number){
				part1 =part1 + (j+1);
				i++;
			}else{
				part2 = part2 + (row)-i;
				j--;
			}
		}
		return part2;
		
	}
	public static void main(String[] args) {
		MatrixSearch matrixSearch = new MatrixSearch();
		System.out.println(matrixSearch.kSmallestElement(15));
//		System.out.println(matrixSearch.kLargestElement(5));
		
	}
}
