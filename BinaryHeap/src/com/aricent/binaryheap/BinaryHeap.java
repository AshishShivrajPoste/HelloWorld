package com.aricent.binaryheap;

public class BinaryHeap {

	
	private static int[] heap = new int[10];
	private int size = 0;
	public void maxHeapInsert(int number){
		 if(size == heap.length-1){
			 doubleSize();
		 }
		 int pos = ++size;
		 for(;pos>1 && number > heap[pos/2];pos = pos/2){
			 heap[pos] = heap[pos/2];
		 }
		 heap[pos] = number;
	 }
	
	public int  maxHeapDeletion(){
		int minValue = heap[1];
		heap[1] = heap[size];
		heap[size] = -1;
		size--;
		maxHeapify(1);
		return minValue;
	}
	private void maxHeapify(int i){
		int l=0,r=0,largest = 0;
		l = 2*i;
		r = 2*i + 1;
		if(l < heap.length && heap[l] > heap[i]){
			largest = l;
		}else{
			largest = i;
		}
		if(r < heap.length && heap[r] > heap[largest]){
			largest = r;
		}
		if(largest != i){
			swap(i,largest);
			maxHeapify(largest);
		}
	}
	private void swap(int a , int b){
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	 public void minHeapInsert(int number){
		 if(size == heap.length-1){
			 doubleSize();
		 }
		 int pos = ++size;
		 for(;pos>1 && number < heap[pos/2];pos = pos/2){
			 heap[pos] = heap[pos/2];
		 }
		 heap[pos] = number;
	 }
	 
	 
	 private void doubleSize(){
		 
	 }
	 public static void main(String[] args) {
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.maxHeapInsert(150);
		binaryHeap.maxHeapInsert(80);
		binaryHeap.maxHeapInsert(40);
		binaryHeap.maxHeapInsert(30);
		binaryHeap.maxHeapInsert(10);
		binaryHeap.maxHeapInsert(70);
		binaryHeap.maxHeapInsert(110);
		binaryHeap.maxHeapInsert(100);
		binaryHeap.maxHeapInsert(20);
		
		
		System.out.println(binaryHeap.maxHeapDeletion());
		System.out.println(binaryHeap.maxHeapDeletion());
		System.out.println(binaryHeap.maxHeapDeletion());
		System.out.println(binaryHeap.maxHeapDeletion());
		System.out.println(binaryHeap.maxHeapDeletion());
		System.out.println(binaryHeap.maxHeapDeletion());
		System.out.println(binaryHeap.maxHeapDeletion());
		System.out.println(binaryHeap.maxHeapDeletion());
		System.out.println(binaryHeap.maxHeapDeletion());
		
		
		System.out.println(heap);	
	 }
}
