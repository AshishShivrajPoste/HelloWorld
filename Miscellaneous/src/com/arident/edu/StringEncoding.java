package com.arident.edu;

public class StringEncoding {

	public String encodingString(StringBuffer str){
		int count = 1;
		int j = 1;
		for(int i = 0;i < str.length();i++){
			
			if(str.charAt(i)==str.charAt(i+1)){
				count++;
			}else{
				str.replace(j+1, i, count+"");
				j = i + 1;
				count = 1;
			}
		}
		return str.toString();
	}
	public static void main(StringBuffer[] args) {
		StringEncoding encoding = new StringEncoding();
		StringBuffer str = new StringBuffer("aaabcccddde");
		encoding.encodingString(str);
	}
}
