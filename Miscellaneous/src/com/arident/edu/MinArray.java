package com.arident.edu;

public class MinArray {

		private static int[] arr = {4,5,3,8,3,7};
//		private static int[] arr =  {1,2,3,4,5,6,7};
		private int[][] cache = null;
		public MinArray(){
			 cache = new int[arr.length][arr.length];
			 for(int i =0;i<arr.length;i++){
				 for(int j =0;j<arr.length;j++){
					 cache[i][j] = -1;
				 }
			 }
		}
		public void sortArray(){
			 for(int j = 1;j<arr.length;j++){
		            int key = arr[j];
		            int i = j-1;
		            while(i>=0 && arr[i]>key){
		                arr[i+1] = arr[i];
		                i--;
		            }
		            arr[i+1] = key;
			 }   
		}
		public int minArray(int first,int last){
			int count1 = 0;
			int count2 = 0;
			if(cache[first][last] != -1){
				return cache[first][last];
			}
			if(first <= last){
				if(arr[last] > arr[first]*2){
					count1  = minArray(first+1, last)+1;
					count2 = minArray(first, last-1)+1;
				}
			}
			
			if(count1 <= count2){
				cache[first][last] = count1;
				return count1;
			}else{
				cache[first][last] = count2;
				return count2;
			}
		}
		public static void main(String args[]){
			MinArray s =new MinArray();
			s.sortArray();
			System.out.println(s.minArray(0,arr.length-1));
		}
}
