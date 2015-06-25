package com.ashish.edu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Encoding {
	public String encode(String encodeString){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder outStringBuilder = new StringBuilder();
		List<Character> listofCharacters = new ArrayList<Character>();
		for(int i = 0; i < encodeString.length();i++){
			Character character = encodeString.charAt(i);
			if(map.get(character) != null){
				int count = map.get(character);
				count = count + 1;
				map.put(character, count);
			}else{
				map.put(character, 1);
				listofCharacters.add(character);
			}
		}
		for(Character character : listofCharacters){
			outStringBuilder.append(character).append(map.get(character));
		}
		return outStringBuilder.toString();
	}
	public static void main(String[] args) {
		Encoding encoding = new Encoding();
		System.out.println(encoding.encode("ZZZA"));
		
	}
}
