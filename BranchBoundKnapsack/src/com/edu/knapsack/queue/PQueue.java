package com.edu.knapsack.queue;

import java.util.Comparator;
import com.edu.knapsack.Item;

/***
 * Priority Queue Class will sort the Items according to the Value per Unit of Weight in decreasing order
 * and in case of equality it will take the item having more value as first in the sorted order.
 * @author 
 *
 */
public class PQueue implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		if(o1.getValueperUnit() > o2.getValueperUnit()){
			return -1;
		}else if(o1.getValueperUnit() < o2.getValueperUnit()){
			return 1;
		}else {
			if(o1.getValue() > o2.getValue()){
				return -1;
			}else if(o1.getValue() < o2.getValue()){
				return 1;
			}else{
				return 0;
			}
		}
		
	}
}
