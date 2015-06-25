
public class QuickSort {

	public void QuickSort(int[] array,int p ,int r){
		
		if(p < r){
			int pivot = array[r];
			int q = partition(array,p,r,pivot);
			print(array);
			QuickSort(array,p,q-1);
			QuickSort(array,q+1,r);
		}
	}

	private void print(int[] array) {
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private int partition(int[] array, int p, int r, int pivot) {
		
		int i = p-1;
		for(int j = p; j < r;j++){
			if(array[j] <= pivot){
				i = i + 1;
				swap(array , i,j);
			}
		}
		i = i + 1;
		swap(array,i,r);
		return i;
	}

	private void swap(int[] array,int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String[] args) {
		int[] array = {7,2,10,6,1,5,3,9,12,13,8};
		QuickSort quickSort = new QuickSort();
		quickSort.QuickSort(array, 0, array.length-1);
	}
}
