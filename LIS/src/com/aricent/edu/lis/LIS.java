package com.aricent.edu.lis;

public class LIS {
	 public static int longestSeq(int[] input1)
	    {
		 	int inputSize = input1.length;
		 	int[] lis = new int[inputSize];
		 	for(int i = 0; i < inputSize;i++){
		 		lis[i] = 1;
		 	}
		 	for (int i = 0; i < inputSize; i++) {
				for (int j = 0; j < i; j++) {
					if(input1[i] > input1[j] && lis[i] < lis[j] + 1){
						lis[i] = lis[j] + 1;
					}
				}
			}
		 	int max = -1;
		 	for (int i = 0; i < inputSize; i++) {
				if(max < lis[i]){
					max = lis[i];
				}
			}
		 return max;
	    }
	 public static void main(String[] args) {
		int[] input1 = {10,22,9,33,21,50,41,60};
		LIS  lis = new LIS();
		System.out.println(lis.longestSeq(input1));
	}
}
