package com.aricent.edu.mergesort;

public class MergeSort {

	public void mergeSort(int[] array,int p,int r){
		if(p < r){
			int q = (p + r)/2;
			mergeSort(array, p, q);
			mergeSort(array, q+1, r);
			merge(array,p,q,r);
		}
	}
	public void merge(int[] array,int p ,int q,int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for(int i = 0;i < n1;i++){
			L[i] = array[p+i];
		}
		for(int j = 0;j < n2;j++){
			R[j] = array[q+j+1];
			
		}
		L[n1] = (int)(1.0/0);
		R[n2] = (int)(1.0/0);
		int i = 0;
		int j = 0;
		
		for(int k  = p; k <= r;k++){
			if(L[i] <= R[j]){
				array[k] = L[i];
				i++;
			}else{
				array[k] = R[j];
				j++;
			}
		}
	}
	public static void main(String[] args) {
		int[] array = {8,3,2,4,6,9,1,2,5};
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(array, 0, array.length-1);
		
	}
}
