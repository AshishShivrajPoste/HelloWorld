package com.aricent.edu.palindrome;

public class CheckPalindrome {

	public int checkPal(String str){
		int start =  0;
		int end = str.length() - 1;
		while(start <= end){
			char startc =  str.charAt(start);;
			int ascii1 = (int) startc;;
			while(!((ascii1 >= 65 && ascii1 <= 90) || (ascii1 >= 97 && ascii1 <= 122))){
				start = start +1;
				startc = str.charAt(start);
				ascii1 = (int) startc;
			}
			char endc = str.charAt(end);
			int ascii2 = (int) endc;;
			while(!((ascii2 >= 65 && ascii2 <= 90) || (ascii2 >= 97 && ascii2 <= 122))){
				end = end - 1;
				endc = str.charAt(end);
				ascii2 = (int) endc;
			}	
			if(str.charAt(start) == str.charAt(end)){
				start = start + 1;
				end = end -1;
			}else{
				return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args) {
		String str = new String("i l?????ove my ? 5 6 4 india a1657452132145615247827490238409id7n9i1ym2evoli");
		Long startTime = System.nanoTime();
		CheckPalindrome palindrome = new CheckPalindrome();
		System.out.println(palindrome.checkPal(str));
		System.out.println("Total Time-->"+(System.nanoTime() - startTime));
	}
}
