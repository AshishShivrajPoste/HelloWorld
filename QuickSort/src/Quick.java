
public class Quick {

	public void Quicksort(int[] array,int first,int last){
		if(first<last){
			int p = partition(array,first,last);
			Quicksort(array,first,p-1);
			Quicksort(array, p+1, last);
			
		}
	}
	
	private int partition(int[] array, int first, int last) {
	
			int pivot = array[first];
			int i = first+1;
			int j = last;
			while(i<=j){
				while(array[i] < pivot){
					i++;
				}
				while(array[j] > pivot){
					j--;
				}
				if(i<=j){
					swap(array ,i,j);
					i++;
					j--;
				}
				
			}
			swap(array,first,j);
			return j;
	}
	public void swap(int[] array , int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String args[]){
		int[] array = {10,5,2,9,3,12,1,7};
		Quick quick = new Quick();
		quick.Quicksort(array, 0, array.length-1);
		System.out.println(array);
	}
}
