package com.aricent.edu;

import java.util.ArrayList;
import java.util.List;

public class ChangeMaking {

	private List<Integer> c = null;
	private List<Integer> s = null;
	
	public ChangeMaking(){
		c = new ArrayList<Integer>();
		s = new ArrayList<Integer>();
	}
	public void change(int [] d,int n){
		int p,i,coin = 0;
		c.add(0);
		for(p = 1;p <= n; p++){
			int min = (int) (1.0/0);
			for(i = 0; i<d.length;i++){
				if(d[i] <= p){
					if(1 + c.get(p-d[i]) < min){
						min = 1 + c.get(p - d[i]);
						coin = i;
					}
				}
			}
			c.add(min);
			s.add(coin);
		}
	}
	public void print(List<Integer> array){
		for(int j = 0;j<array.size();j++){
			System.out.print(" "+array.get(j));
		}
	}
	public void solution(List<Integer> s,int d[],int N){
		while(N > 0){
			System.out.println(d[s.get(N-1)]);
			N = N - d[s.get(N-1)];
		}
	}
	public static void main(String[] args) {
		ChangeMaking changeMaking = new ChangeMaking();
		int d[] = new int[3];
		d[0] = 1;
		d[1] = 2;
		d[2] = 3;
		int N = 5;
		changeMaking.change(d,N);
		changeMaking.print(changeMaking.c);
		System.out.println();
		changeMaking.print(changeMaking.s);
		System.out.println();
		changeMaking.solution(changeMaking.s, d, 4);
	}
}
