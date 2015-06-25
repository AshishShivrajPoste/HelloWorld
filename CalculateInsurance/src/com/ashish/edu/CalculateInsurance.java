package com.ashish.edu;

public class CalculateInsurance {

	public int claculateIsurance(int[] weightofBoxes){ 
		int insuranceCost = 0;
		 int totalWeight = 0;
		 int maxWeight = 0;
		 int counter = 0;
		 for(int weight : weightofBoxes){
			 if(weight > maxWeight){
				 counter =1;
				 maxWeight = weight;
			 }else if(weight == maxWeight){
				 counter++;
				 maxWeight = weight;
			 }
			 totalWeight = totalWeight + weight;
		 }
		 totalWeight = (totalWeight - (maxWeight * counter));
		 insuranceCost = ((totalWeight * 2) + (maxWeight*counter*3));
		 return insuranceCost; 
	}
	
	public static void main(String[] args) {
	
		int[] listofWeightofItems = {20,10,5,20,40,20,41,41,2,6,7,3,4,5,6,23,34,7,8,9,2};
		CalculateInsurance insuranceCalculator = new CalculateInsurance();
		int insuranceCost = insuranceCalculator.claculateIsurance(listofWeightofItems);
		System.out.println("Total Insurance Cost is : "+insuranceCost);
		
	}
}
