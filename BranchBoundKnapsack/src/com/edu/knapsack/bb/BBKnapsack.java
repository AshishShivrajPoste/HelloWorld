package com.edu.knapsack.bb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

import com.edu.knapsack.Item;
import com.edu.knapsack.Node;
import com.edu.knapsack.queue.PQueue;

/***
 * The Class provide the Branch & Bound Strategy to implementation of 0-1 knapsack Algorithm
 * @author 
 *
 */
public class BBKnapsack {

    private double maxValue;
    private double knapsack;             //knapsack capacity
    private double [] sizeArray;           //array of sizes
    private double [] valueArray;           //array of values (both ordered by value density)
    private Vector<Integer> bestList;      //members of solution set for current best value
    private int numItems;          //number of items in set to select from                                          //(first item is dummy 0
    private Queue<Node> queue;
    private static  Scanner scanner;
	private static FileInputStream fin;
	private static List<Item> listofItems;
    public BBKnapsack(double capacity, int num) {
           maxValue = 0.0;
           knapsack = capacity;
           sizeArray = new double[num+1];
           valueArray = new double[num+1];
           numItems = num;
           bestList = null;
           queue = new LinkedList<>();
           calculateValueperUnit();
           Collections.sort(listofItems, new PQueue());
           populateInput();
    }
    /**
     * The method uses Breath First Search to traverse the Tree created to get the solution.
     */
    private void knapsack( ) {
    	while (!queue.isEmpty( ) ) {
            Node temp = (Node) queue.poll();
            if (temp.bound > maxValue) {
                 Node leftNode = new Node( );
                 leftNode.level = temp.level + 1;
                 leftNode.size = temp.size + sizeArray[temp.level + 1];
                 leftNode.value = temp.value + valueArray[temp.level + 1];
                 leftNode.copyList(temp.contains);
                 leftNode.add(temp.level);
                 if (leftNode.size <= knapsack)  {
                       maxValue = leftNode.value;
                       bestList = new Vector(leftNode.contains);
                 }
                 leftNode.bound = bound(leftNode.level, leftNode.size, leftNode.value);
                 if (leftNode.bound > maxValue && leftNode.level < numItems)
                       queue.offer(leftNode);
                 Node rightNode = new Node( );
                 rightNode.level = temp.level + 1;
                 rightNode.size = temp.size;
                 rightNode.value = temp.value;
                 rightNode.copyList(temp.contains);
                 rightNode.bound = bound(rightNode.level, rightNode.size, rightNode.value);
                 if (rightNode.bound > maxValue && rightNode.level < numItems)
                       queue.offer(rightNode);
            }
       }
    }
    /**
     * 
     * @param item
     * @param size
     * @param value
     * @return
     */
    private double bound (int item, double size, double value) {
          double bound = value;
           double totalSize = size;
           int k = item+1;
           if (size > knapsack)  return 0.0;
           while (k < numItems && totalSize + sizeArray[k] <= knapsack) {
                bound += valueArray[k];
                totalSize += sizeArray[k];
                k++;
           }
           if (k < numItems){
        	   bound += (knapsack - totalSize) * (valueArray[k]/sizeArray[k]);
           }
           return bound;
    }
    public void populateInput(){
    	sizeArray[0] = 0;
		valueArray[0] = 0;
    	for(int i = 0; i < listofItems.size();i++)
    	{
    		sizeArray[i+1] = listofItems.get(i).getWeight();
    		valueArray[i+1] = listofItems.get(i).getValue();
    	}
    }
    /**
	 * This Method will calculate the value per unit of weight for each item i.e value/weight
	 * @param listofItems : Take input as all the Items in problem
	 */
	public void calculateValueperUnit(){
		
		for(Item item : listofItems){
			double valueperUnit = (double)(item.getValue()/item.getWeight());
			item.setValueperUnit(valueperUnit);
		}
	}
	/***
	 * Calculate the maximum Knapsack value and find the items included into the knapsack
	 * @return : list if items included into knapsack
	 */
	public List<Item> findSolution( ) {
		   List<Item> output = new ArrayList<Item>();
           Node root = new Node( );
           root.level = 0;
           root.size = 0.0;
           root.value = 0.0;
           root.bound = bound(0, 0.0, 0.0);
           root.copyList(null);
           queue.offer(root);
           knapsack();
           for (int i = 0; i < bestList.size(); i++) {
                output.add(listofItems.get(bestList.get(i)));
           }
           return output;
    }
           /***
       	 * Provide input file as command line argument with absolute path of the file (i.e full path)
       	 * @param args
       	 */
       	public static void main(String[] args) {
       		if(args.length == 0){
       			System.out.println("Please provide Input file as command line argument(Full Path of the file)");
       			return;
       		}
       		String filePath = args[0];
       		try {
       			fin = new FileInputStream(new File(filePath));
       		} catch (FileNotFoundException e) {
       			e.printStackTrace();
       		}
               scanner = new Scanner(fin);
       		int totalValue = 0;
       		int totalWeight = 0;
       		int totalItem = scanner.nextInt();
       		int knapsackSize = scanner.nextInt();
       		listofItems = new ArrayList<Item>(totalItem);
       		for(int i = 0; i < totalItem;i++){
       			Item item = new Item(scanner.nextInt(),scanner.nextInt());
       			listofItems.add(item);
       		}
       		 BBKnapsack bbKnapsack = new BBKnapsack(knapsackSize,totalItem);
       		List<Item> outputList =  bbKnapsack.findSolution();
       		System.out.println("****** BRANCH AND BOUND ALGORITHM FOR 0-1 KNAPSACK SOLUTION******");
       		System.out.println("Solution Contains Elements");
       		for(Item item : outputList){
       			System.out.println(item);
       			totalValue = totalValue + item.getValue();
       			totalWeight  = totalWeight + item.getWeight();
       		}
       		System.out.println("Total Value  : "+totalValue);
       		System.out.println("Total Weight : "+totalWeight);
       	}
}


