package com.aricent.edu.quicksort;

public class QuickSort {

	public void quickSort1(int[] array,int p,int r){
		int q;
		if(p<r){
			q = partition1(array,p,r);
			quickSort1(array, p, q-1);
			quickSort1(array, q+1, r);
		}
	}
	private int partition1(int[] array,int p,int r){
		int i = p-1;
		int pivot = array[r];
		for(int j = p;j <= (r-1);j++){
			if(array[j] <= pivot){
				i++;
				swap(array,i,j);
			}
		}
		swap(array,i+1,r);
		return i+1;
	}
	public void quickSort2(int[] array,int p,int r){
		int q;
		if(p<r){
			q = partition2(array,p,r);
			quickSort2(array, p, q-1);
			quickSort2(array, q+1, r);
		}
	}
	private int partition2(int[] array,int p,int r){
		int pivot = array[p];
		int i = p;
		int j = r;
		while(true){
			while(array[i] < pivot){
				i++;
			}
			while(array[j] > pivot ){
				j--;
			}
			if(i < j){
				swap(array,i,j);
			}else{
				return j;
			}
		}
	}
	
	private void swap(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public void sortPositiveNegativeNumbers(int[] A)
	{
		int i = -1;
		int zeroIndex = -1;
		for(int j = 0;j < A.length;j++){
			if(A[j] <= 0){
				int negNumber = A[j];
				for(int k = j;k >= i+1;k--){
					if(k == i +1){
						i = i + 1;
						A[i] = negNumber;
						if(negNumber == 0){
							zeroIndex = i;
						}
					}else{
						A[k] = A[k-1];
					}
				}
			}else if(A[j] == 0){
				zeroIndex = j;
			}
		}
		for(int k = zeroIndex;k < i ;k++){
			A[k] = A[k+1];
		}
		A[i] = 0; 
		System.out.println(A);
	}
	public static void main(String[] args) {
//		int [] array = {2,8,7,3,5,6,4};
		int [] array = {-1,3,4,0,-5,-6,-7,5,2,7,-4};
		QuickSort quickSort = new QuickSort();
		quickSort.sortPositiveNegativeNumbers(array);
		quickSort.quickSort2(array, 0, array.length-1);
//		quickSort.quickSort1(array, 0, array.length-1);
		System.out.println(array);
	}
}
