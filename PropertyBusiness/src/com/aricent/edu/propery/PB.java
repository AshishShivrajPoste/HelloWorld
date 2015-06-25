package com.aricent.edu.propery;

import java.util.ArrayList;
import java.util.List;

public class PB {

	private List<String> pathtoParent(String[] input1,int customer1)
    {
		String[] a = {"",""};
		int b = a.length;
        List<String> list = new ArrayList<>();
        int index = customer1;
        while(index > 1){
        	index = index/2;
        	list.add(input1[index]);
        }
        return list;
    }
	public int maxDealer(String[] input1,int customer1,int customer2){
		int count = 0;
		List<String> customer1PathtoRoot = pathtoParent(input1, customer1);
		List<String> customer2PathtoRoot = pathtoParent(input1, customer2);
		
		if(customer1PathtoRoot.size() > customer2PathtoRoot.size()){
			for(int index = 0;index <= customer1PathtoRoot.size();index++){
				if(customer1PathtoRoot.get(index).equalsIgnoreCase(customer2PathtoRoot.get(customer2PathtoRoot.size()-1))){
					count = count + customer2PathtoRoot.size();
					break;
				}else{
					count++;
				}
			}
		}else{
			for(int index = 0;index <= customer2PathtoRoot.size();index++){
				if(customer2PathtoRoot.get(index).equalsIgnoreCase(customer1PathtoRoot.get(customer1PathtoRoot.size()-1))){
					count = count + customer1PathtoRoot.size();
					break;
				}else{
					count++;
				}
			}
		}
		return count;
	}
	public static List<String> getPossibleShootingPosition(int targetX,int targetY,String direction,String[] bulletProof,int xCodBattleFeild,int yCodBattleFeild){
//    	List<String> listofCells = new ArrayList<String>();
    	listofCells.add("");
    	String[] listofCells = new String[];
    	if(direction.equalsIgnoreCase("north")){
    		for(int i = xCodBattleFeild-1;i > 0;i++){
    			for(String bulletCell : bulletProof){
    				if(!((i+"#"+yCodBattleFeild).equalsIgnoreCase(bulletCell))){
    						listofCells.add(i+"#"+yCodBattleFeild);
    				}
    			}
    		}
    	}else if(direction.equalsIgnoreCase("south")){
    	
    	}else if(direction.equalsIgnoreCase("west")){
    	
    	}else if(direction.equalsIgnoreCase("east")){
    	
    	}else if(direction.equalsIgnoreCase("nortwest")){
    	
    	}else if(direction.equalsIgnoreCase("northwest")){
    	
    	}else if(direction.equalsIgnoreCase("southwest")){
    	
    	}else if(direction.equalsIgnoreCase("southeast")){
    	
    	}
    }
    }
	public static void main(String[] args) {
		String[] list = {"0","1","2","3","4","5","6","7","8","9"};
		String test = new String("1#2");
		String[] str = test.split("#");
		System.out.println("X-->"+str[0]);
		System.out.println("Y-->"+str[1]);
		PB pb = new PB();
		System.out.println(pb.maxDealer(list, 8, 9));
	}
}
