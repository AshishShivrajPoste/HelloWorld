package com.aricent.edu.propery;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class CandidateCode 
{ 
    public static String[] getPosition(String input1,String input2,String input3,String[] input4)
    {
    	String[] temp = input1.split("#");
        int xCodBattleFeild = Integer.parseInt(temp[0]);
        int yCodBattleFeild = Integer.parseInt(temp[1]);


        temp = input2.split("#");
        int xCodSolider = Integer.parseInt(temp[0]);
        int yCodSolider = Integer.parseInt(temp[1]);
    
        temp = input3.split("#");
        int xCodTarget = Integer.parseInt(temp[0]);
        int yCodTarget = Integer.parseInt(temp[1]);
    	
    	List<String> eligibleCells = getPossibleShootingPosition(xCodTarget,yCodTarget,input4,xCodBattleFeild , yCodBattleFeild );
    	int min = (int)(1.0/0);
    	List<String> minDistanceCells = new ArrayList();
    	for(String cell : eligibleCells )	    
    	{
    		String[] tempCellcod = cell.split("#");
    		int x = Integer.parseInt(tempCellcod [0]);
    		int y = Integer.parseInt(tempCellcod [1]);
    		int distance = (x - xCodSolider)+(y - yCodSolider);
    		if(cell.equalsIgnoreCase("1#5")){
    			System.out.println("Distance->"+distance);
    		}
    		if(distance < min){
    			minDistanceCells = new ArrayList();
    			minDistanceCells.add(cell);
    			min = distance;
    		}else if(distance == min){
    			minDistanceCells.add(cell);
    			min = distance;
    		}
    	}
    	return minDistanceCells.toArray(new String[minDistanceCells.size()]);
    } 
    public static List<String> getPossibleShootingPosition(int targetX,int targetY,String[] bulletProof,int xCodBattleFeild,int yCodBattleFeild){
    	
    		List listofCells = new ArrayList();
    		for(int i = targetX-1;i > 0;i--){
    			for(String bulletCell : bulletProof){
    				if(!((i+"#"+targetY).equalsIgnoreCase(bulletCell))){
    						listofCells.add(i+"#"+targetY);
    				}
    			}
    		}
    		for(int i = targetX+1;i <= xCodBattleFeild;i++){
    			for(String bulletCell : bulletProof){
    				if(!((i+"#"+targetY).equalsIgnoreCase(bulletCell))){
    						listofCells.add(i+"#"+targetY);
    				}
    			}
    		}
	    	for(int j = targetY - 1;j > 0;j--){
    			for(String bulletCell : bulletProof){
    				if(!((targetX+"#"+j).equalsIgnoreCase(bulletCell))){
    						listofCells.add(targetX+"#"+j);
    				}
    			}
    		}
    		for(int j = targetY + 1;j <= yCodBattleFeild;j++){
    			for(String bulletCell : bulletProof){
    				if(!((targetX+"#"+j).equalsIgnoreCase(bulletCell))){
    						listofCells.add(targetX+"#"+j);
    				}
    			}
    		}
    		int i = targetX-1;
    		int j = targetY-1;
    		while(i >= 1 && j >= 1){
	    			for(String bulletCell : bulletProof){
    					if(!((i+"#"+j).equalsIgnoreCase(bulletCell))){
    						listofCells.add(i+"#"+j);
    					}	
	    			}
	    			i = i-1;
	    			j = j-1;
    		}
    		i = targetX-1;
    		j = targetY+1;
    		while(i >= 1 && j <= yCodBattleFeild){
	    			for(String bulletCell : bulletProof){
    					if(!((i+"#"+j).equalsIgnoreCase(bulletCell))){
    						listofCells.add(i+"#"+j);
    				}
	    		}
	    		i = i - 1;
	    		j = j + 1;
    		}
    		i = targetX+1;
    		j = targetY -1;
    		while(i <= xCodBattleFeild && j >=1){
	    			for(String bulletCell : bulletProof){
    					if(!((i+"#"+j).equalsIgnoreCase(bulletCell))){
    						listofCells.add(i+"#"+j);
    				}	
    			}
	    			i = i + 1;
		    		j = j - 1;
    		}
    		i = targetX+1;
    		j = targetY+1;
    		while(i <= xCodBattleFeild && j <= yCodBattleFeild){
	    			for(String bulletCell : bulletProof){
    					if(!((i+"#"+j).equalsIgnoreCase(bulletCell))){
    						listofCells.add(i+"#"+j);
    				}	
    			}
	    			i = i + 1;
		    		j = j + 1;
    		}
    	return listofCells;
    }
    public static void main(String[] args) {
		CandidateCode candidateCode =  new CandidateCode();
		String[] bulletCells = {""};
		String[] result = candidateCode.getPosition("25#25", "1#5", "10#14", bulletCells);	
		for(String str : result){
			System.out.println(str);
		}
	}
}