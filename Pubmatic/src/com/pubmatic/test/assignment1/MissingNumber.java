package com.pubmatic.test.assignment1;

/**
 * 
 * @author ashishposte
 *Find the missing number between two integer arrays.
 *The elements in first Arrays are XOR with each other,elements in second array
 *are XOR ,the results obtained by XOR of the two arrays are XOR with each other
 *which gives the missing number between two arrays
 */
public class MissingNumber {

	public Integer findMissingNumber(Integer[] firstArray,Integer[] secondArray){
		Integer firstArraySize = firstArray.length;
		Integer secondArraySize = secondArray.length;
		Integer firstArraySum = firstArray[0];
		Integer secondArraySum = secondArray[0];
		for (int index = 1; index < firstArraySize; index++) {
			System.out.print(firstArraySum + ",");
			firstArraySum = firstArraySum ^ firstArray[index];
			
		}
		System.out.println();
		for (int index = 1; index < secondArraySize; index++) {
			System.out.print(secondArraySum + ",");
			secondArraySum = secondArraySum ^ secondArray[index];
		}
		Integer missingNumber = firstArraySum ^ secondArraySum;
		return missingNumber;
	}
	
	public static void main(String[] args) {
		MissingNumber missingNumber = new MissingNumber();
		
		Integer[] firstArray = {4,1,0,2,9,6,8,7,5,3};
		Integer[] secondArray = {6,4,7,2,1,0,8,3,9};
		Integer result = missingNumber.findMissingNumber(firstArray, secondArray);
		System.out.println("Result : "+result);
	}
}
