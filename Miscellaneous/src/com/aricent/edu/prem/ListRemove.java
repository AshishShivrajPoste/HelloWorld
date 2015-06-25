package com.aricent.edu.prem;

import java.util.ArrayList;
import java.util.List;

public class ListRemove {

		public static void main(String[] args) {
			List<String> listofString = new ArrayList<String>();
			
			listofString.add("1A");
			listofString.add("1B");
			listofString.add("1C");
			listofString.add("1D");
			listofString.add("1E");
			listofString.add("1F");
			listofString.add("1G");
			listofString.add("1H");
			int size = listofString.size();
			for(int i = 0;i < listofString.size();i++){
				if(listofString.get(i).startsWith("1")){
					listofString.remove(i);
					i--;
				}
			}
			
		}
}
