package com.ashish.edu.huffmanencoding;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
public class CandidateCode 
{ 
    public static String constructTree(String input1)
    {
    	if (input1 == null) {
    	}
    	if (input1.length() == 0) {
    	}
    
    	Map<Character, Integer> charFreq =  getCharFrequency(input1);
    	HuffmanNode root = buildTree(charFreq);
    	final Map<Character, String> charCode = generateCodes(charFreq.keySet(), root);
    	final String encodedMessage = encode(charCode, input1);
    	return encodedMessage;
    }
    
    private static String encode(Map<Character, String> charCode,String input1) {
    	final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input1.length(); i++) {
            stringBuilder.append(charCode.get(input1.charAt(i)));
        }
        return stringBuilder.toString();
	}

	private static Map<Character, String> generateCodes(Set<Character> keySet,HuffmanNode root) {
		Map<Character, String> map =  new HashMap<Character, String>();
		generateCode(root,map,"");
		return map;
	}

	private static void generateCode(HuffmanNode node, Map<Character, String> map, String s) {
		if (node.left == null && node.right == null) {
            map.put(node.ch, s);
            return;
        }    
		generateCode(node.left, map, s + '0');
		generateCode(node.right, map, s + '1' );
		
	}

	private static HuffmanNode buildTree(Map<Character, Integer> charFreq) {
    	Queue<HuffmanNode> nodeQueue = createNodeQueue(charFreq);
    	while(nodeQueue.size() > 1){
    		HuffmanNode node1 = nodeQueue.remove();
    		HuffmanNode node2 = nodeQueue.remove();
    		HuffmanNode node = new HuffmanNode('\0', node1.frequency + node2.frequency, node1, node2);
    		nodeQueue.add(node);	
    	}
		return nodeQueue.remove();
	}

	private static Queue<HuffmanNode> createNodeQueue(Map<Character, Integer> charFreq) {
		Queue<HuffmanNode> pq = new PriorityQueue<CandidateCode.HuffmanNode>(10, new HuffManComparator());
		 for (Entry<Character, Integer> entry : charFreq.entrySet()) {
	            pq.add(new HuffmanNode(entry.getKey(), entry.getValue(), null, null));
	       }
		 return pq;
	}

	private static Map<Character, Integer> getCharFrequency(String sentence) {
        final Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
//            if(ch == 'a'){
//            	map.put(ch,  4);
//            }else if(ch == 'b'){
//            	map.put(ch, 2);
//            }
//            else if(ch == 'c'){
//            	map.put(ch, 1);
//            }
//            else if(ch == 'd'){
//            	map.put(ch, 1);
//            }
//            else if(ch == 'e'){
//            	map.put(ch, 2);
//            }
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                int val = map.get(ch);
                map.put(ch, ++val);
            }
        }

        return map;
    }
    
    private static class HuffmanNode {
        private char ch;
        private int frequency;
        private HuffmanNode left;
        private HuffmanNode right;

        public HuffmanNode(char ch, int frequency,  HuffmanNode left,  HuffmanNode right) {
            this.ch = ch;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
       
    }
    private static class HuffManComparator implements Comparator<HuffmanNode> {
        @Override
        public int compare(HuffmanNode node1, HuffmanNode node2) {
            return node1.frequency - node2.frequency;
        }
    }
    public static void main(String[] args) {
		System.out.println(CandidateCode.constructTree("abcde"));
	}
}