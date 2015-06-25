package com.edu.knapsack;
/***
 * Item is a data holder for each item in 0-1 Knapsack Problem
 * It will hold the value, weight and value per Unit of Weight
 * @author 
 *
 */
public class Item {

	private int value;
	private int weight;
	private double valueperUnit;
	
	
	public Item(){}
	public Item(int value,int weight){
		this.value = value;
		this.weight = weight;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getValueperUnit() {
		return valueperUnit;
	}
	public void setValueperUnit(double valueperUnit) {
		this.valueperUnit = valueperUnit;
	}
	@Override
	public String toString() {
		return "Item [value=" + value + ", weight=" + weight
				+ ", valueperUnit=" + valueperUnit + "]";
	}
	
}
