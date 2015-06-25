package com.aricent.edu.lcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FindingLCS {

		private static List<String> sequence_1 = Arrays.asList("A","C","C","G","G","T","C","G","A","G","T","G","C","G","C","G","G","A","A","G","C","C","G","G","C","C","G","A","A");
		private static List<String> sequence_2 = Arrays.asList("G","T","C","G","T","T","C","G","G","A","A","T","G","C","C","G","T","T","G","C","T","C","T","G","T","A","A","A");
		
//		private static List<String> sequence_1 = Arrays.asList("A","B","C","B","D","A","B");
//		private static List<String> sequence_2 = Arrays.asList("B","D","C","A","B","A");
		public void LCS_Length(int[][] c,String[][] b,int seq1_Size,int seq2_Size){
			
			for(int index = 1;index < seq1_Size;index++){
				c[index][0] = 0;
			}
			for(int index = 1;index <  seq2_Size;index++){
				c[0][index] = 0;
			}
			for(int index1 = 1;index1 < seq1_Size;index1++){
				for(int index2 = 1;index2 < seq2_Size;index2++){
					if(sequence_1.get(index1-1).equalsIgnoreCase(sequence_2.get(index2-1))){
						c[index1][index2] = c[index1-1][index2-1] + 1;
						b[index1][index2] = "\\";
					}else if(c[index1-1][index2] >= c[index1][index2-1]){
						c[index1][index2] = c[index1-1][index2];
						b[index1][index2] = "↑";
					}else {
						c[index1][index2] = c[index1][index2-1];
						b[index1][index2] = "←";
					}
				}
			}
		}
		public void  printMatrixc(int[][] c,int seq1_Size,int seq2_Size){
			for(int index1 = 0;index1 < seq1_Size;index1++){
				System.out.println();
				for(int index2 = 0;index2 < seq2_Size;index2++){
					System.out.print(" "+c[index1][index2]);
				}
			}
		}
		public void  printMatrixb(String[][] b,int seq1_Size,int seq2_Size){
			for(int index1 = 0;index1 < seq1_Size;index1++){
				System.out.println();
				for(int index2 = 0;index2 < seq2_Size;index2++){
					System.out.print(" "+b[index1][index2]);
				}
			}
		}
		public void printLCS(String[][] b ,List<String> sequence_1,int i,int j){
				if(i == 0 || j == 0){
					return;
				}
				if(b[i][j].equalsIgnoreCase("\\")){
					printLCS(b,sequence_1,i-1,j-1);
					System.out.print(" "+sequence_1.get(i-1));
				}else if(b[i][j].equalsIgnoreCase("↑")){
					printLCS(b,sequence_1,i-1,j);
				}else {
					printLCS(b,sequence_1,i,j-1);
				}
		}
		public static void main(String args[]){
			int seq1_Size = sequence_1.size()+1;
			int seq2_Size = sequence_2.size()+1;
			int[][] c = new int[seq1_Size][seq2_Size];
			String[][] b = new String[seq1_Size][seq2_Size];
			FindingLCS findingLCS = new FindingLCS();
			findingLCS.LCS_Length(c, b,seq1_Size,seq2_Size);
			findingLCS.printMatrixc(c,seq1_Size,seq2_Size);
			findingLCS.printMatrixb(b,seq1_Size,seq2_Size);
			System.out.println();
			findingLCS.printLCS(b, sequence_1, seq1_Size-1, seq2_Size-1);
		}
}
