package com.aricent.edu.subsetsum;

public class SubsetSum {

	public Boolean findingSubsetSum(int[] set,int n,int sum){
		
		if(sum == 0){
			return true;
		}
		if(n == 0 && sum != 0){
			return false;
		}
		if(set[n-1]>sum){
			return findingSubsetSum(set, n-1,sum);
		}else{
			return (findingSubsetSum(set, n-1, sum)|| findingSubsetSum(set, n-1, sum-set[n-1]));
		}
	}
	public static void main(String[] args) {
		int[] set = {1,7,6,5,5};
		int n = set.length;
		SubsetSum subsetSum = new SubsetSum();
		System.out.println(subsetSum.findingSubsetSum(set,n,10));
	}
}
