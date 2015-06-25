package com.aricent.edu.matrixchain;

import java.util.ArrayList;
import java.util.List;

public class MatriXChainOrdering {

	
	public void matrixChainOrder(List<Integer> listofmatrices,int[][] m,int[][] s){
		Integer maxChainLength = listofmatrices.size()-1;
		int j;
		int q;
		for(int chainlenght = 2;chainlenght <= maxChainLength;chainlenght++){
			for(int i = 1;i <= maxChainLength-chainlenght+1;i++){
				j = i + chainlenght-1;
				for(int k = i;k <= j-1;k++){
					q = m[i][k] + m[k+1][j] + (listofmatrices.get(i-1)*listofmatrices.get(k)*listofmatrices.get(j));
					if(q <= m[i][j] || m[i][j] == 0){
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
	}
	public void printoptimalParameter(int[][] s , int i , int j){
		if(i == j){
			System.out.print("A"+i);
		}else{
			System.out.print("(");
			printoptimalParameter(s,i,s[i][j]);
			printoptimalParameter(s,s[i][j]+1,j);
			System.out.print(")");
		}
		
	}
	public void  printMatrix(int[][] c,int seq1_Size,int seq2_Size){
		for(int index1 = 1;index1 < seq1_Size;index1++){
			System.out.println();
			for(int index2 = 1;index2 < seq2_Size;index2++){
				System.out.print("    "+c[index1][index2]);
			}
		}
	}
	public static void main(String args[]){
		MatriXChainOrdering matriXChainOrdering = new MatriXChainOrdering();
		List<Integer> listofmatrices = new ArrayList<Integer>();
		int[][] m = null;
		int[][] s = null;
		listofmatrices.add(30);
		listofmatrices.add(35);
		listofmatrices.add(15);
		listofmatrices.add(5);
		listofmatrices.add(10);
		listofmatrices.add(20);
		listofmatrices.add(25);
		Integer inputSize = listofmatrices.size();
		m = new int[inputSize][inputSize];
		s = new int[inputSize][inputSize];
		matriXChainOrdering.matrixChainOrder(listofmatrices, m, s);
		matriXChainOrdering.printMatrix(m,listofmatrices.size(),listofmatrices.size());
		matriXChainOrdering.printMatrix(s,listofmatrices.size(),listofmatrices.size());
		System.out.println();
		matriXChainOrdering.printoptimalParameter(s,1,listofmatrices.size()-1);
		System.out.println(matriXChainOrdering.toString());
		System.out.println(Integer.toHexString(matriXChainOrdering.hashCode())		);
	}
}

