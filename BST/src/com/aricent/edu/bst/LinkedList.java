package com.aricent.edu.bst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

	
public class LinkedList {
	
		private static int N = 0;
		private static Node head;
		private int sum = 0;
		public LinkedList(){
			head = null;
		}
		
		public void insert(int data){
			Node parent = null;
			Node x = head;
			while(null != x){
				parent = x;
				if(data <= x.getData()){
					x = x.getleft();
				}else {
					x = x.getright();
				}
			}
			Node temp = new Node(data);
			temp.setParent(parent);
			if(null == parent){
				temp.setParent(null);
				head = temp;
			}
			else if (data <= parent.getData()) {
				parent.setleft(temp);
			}else{
				parent.setright(temp);
			}
		}
		public void mirrorBST(Node node){
			if(node == null){
				return;
			}
			Node tempNode = new Node(0); 
			mirrorBST(node.getleft());
			mirrorBST(node.getright());
			tempNode = node.getleft();
			node.setleft(node.getright());
			node.setright(tempNode);
			
		}
		public Node search(Node head , int data){
			if(null == head || head.getData() == data){
				return head;
			}
			if(data < head.getData()){
				return search(head.getleft(), data);
			}else {
				return search(head.getright(), data);
			}
			
		}
		public Node minimumNode(Node head){
			Node tempNode = head;
			while(null != tempNode.getleft()){
				tempNode = tempNode.getleft();
			}
			return tempNode;
		}
		public Node maximumNode(Node head){
			Node tempNode = head;
			while(null != tempNode.getright()){
				tempNode = tempNode.getright();
			}
			return tempNode;
		}
		public void inorderTreeWalk(Node node){
			if(null != node){
				inorderTreeWalk(node.getleft());
				System.out.print(" "+node.getData());
				inorderTreeWalk(node.getright());
			}
		}
		public void maxNnumbers(Node node,int k){
			if(null != node ){
				maxNnumbers(node.getright(),k);
				if(++N <= k){
					System.out.print(" "+node.getData());
				}
				maxNnumbers(node.getleft(),k);
			}
		}
		public void ksmallest(int k,Node node){
			Node temp = node;
			Stack<Node> stack = new Stack<Node>();
			while(stack.size() > 0 || temp != null){
				if(temp != null){
					stack.push(temp);
					temp  = temp.getleft();
				}else{
					temp = stack.pop();
					k--;
					if(0 == k){
						System.out.println("Kth smallest element-->"+temp.getData());
						return;
					}
					temp = temp.getright();
				}
			}
		}
		public int BSTHeight(Node node){
			if(node == null){
				return -1;
			}
			if(node.getleft() == null && node.getright() == null){
				return 1;
			}else {
				int leftHeight = BSTHeight(node.getleft())+1;
				int rightHeight = BSTHeight(node.getright())+1;
				if(leftHeight >= rightHeight){
					return leftHeight;
				}else{
					return rightHeight;
				}
			}
		}
		public Node BSTtoDLL(Node node){
			if(null == node){
				return node;
			}
			if(node.getleft() != null){
				Node left = BSTtoDLL(node.getleft());
				for(;left.getright()!=null;left=left.getright());
				left.setright(node);
				node.setleft(left);
			}
			if(node.getright() != null){
				Node right = BSTtoDLL(node.getright());
				for(;right.getleft()!=null;right = right.getleft());
				right.setleft(node);
				node.setright(right);
			}
			return node;
		}
		public void inorderTreeWalksumming(Node node){
			if(null == node){
				return;
			}
			inorderTreeWalksumming(node.getright());
			sum = sum + node.getData();
			node.setData(sum);
			inorderTreeWalksumming(node.getleft());
		}
		
		public int newinorderTreeWalksumming(Node node){
			int sum = 0;
			if(null == node){
				return 0;
			}
			sum = newinorderTreeWalksumming(node.getright()) + sum;
//			sum = sum + node.getData();
			node.setData(sum);
			sum = newinorderTreeWalksumming(node.getleft()) + sum;
			return sum;
		}
		public void verticalSum(Node root){
			if(root == null){
				return;
			}
			Map<Integer, Integer> hmap = new HashMap<>();
			horizontalDistance(root, 0, hmap);
			if(hmap != null){
				System.out.println(hmap.entrySet());
			}
		}
//		public void horizontalDistance(Node root,int hd,Map<Integer, Integer> hmap){
//			if(root == null){
//				return;
//				
//			}else{
//				horizontalDistance(root.getleft(),hd - 1,hmap);
//				System.out.println(""+root.getData());
//				int prevSum = (hmap.get(hd) == null) ? 0 : hmap.get(hd);
//				hmap.put(hd, prevSum + root.getData());
//				horizontalDistance(root.getright(), hd + 1,hmap);
//			}
//		}
		public void horizontalDistance(Node root,int hd,Map<Integer, Integer> hmap){
			if(root == null){
				return;
				
			}else{
				horizontalDistance(root.getleft(),hd - 1,hmap);
				System.out.println(""+root.getData());
				int prevSum = (hmap.get(hd) == null) ? 0 : hmap.get(hd);
				hmap.put(hd, prevSum + root.getData());
				
				horizontalDistance(root.getright(), hd + 1,hmap);
				if(root.getleft().getright()!=null){
					root.getleft().getright().setData(root.getleft().getright().getData() + root.getData()); 
				}
			}
		}
		public static void main(String args[]){
			
			Map<String, String> map = new HashMap<String,String>();
//			map.put("a", "ashish");
//			map.put("b", "bhushan");
//			map.put("c", "chetan");
//			map.put("a", "ashwin");
			LinkedList bst = new LinkedList();
////			bst.insert(399);
//			bst.insert(2);
////			bst.insert(399);
//			bst.insert(387);
//			bst.insert(22);
//			bst.insert(56);
////			bst.insert(24);
////			bst.insert(98);
////			bst.insert(-5);
////			bst.insert(-6);
////			bst.insert(-23);
////			bst.insert(-12);
////			bst.insert(654);
////			bst.insert(12);
////			bst.insert(212);
//			bst.insert(90);
////			bst.insert(65);
////			bst.insert(10);
			bst.insert(10);
			bst.insert(7);
			bst.insert(12);
			bst.insert(5);
			bst.insert(9);
			bst.insert(11);
			bst.insert(15);
//			bst.maxNnumbers(head,10);
			bst.inorderTreeWalk(head);
//			Node resultNode = bst.search(head, 65);
//			if(null != resultNode){
//				System.out.println("Search Result-->"+resultNode.getData());
//			}else{
//				System.out.println("Search Result-->"+resultNode);
//			}
//			System.out.println("MIN Node-->"+bst.minimumNode(head).getData());
//			System.out.println("MAX Node-->"+bst.maximumNode(head).getData());
//			bst.ksmallest(9, head);
//			System.out.println(bst.BSTHeight(head));
			
//			Node root = bst.BSTtoDLL(head);
//			while (root.getleft() != null){
//				root = root.getleft();
//			}
//			System.out.println();
//			while (root != null){
//				System.out.print(" "+root.getData());
//				root = root.getright();
//			}
			int sum = 0;
			bst.verticalSum(head);
			bst.newinorderTreeWalksumming(head);
//			bst.inorderTreeWalksumming(head);
//			bst.inorderTreeWalk(head);
			bst.inorderTreeWalk(head);
			System.out.println();
			bst.mirrorBST(head);
			bst.inorderTreeWalk(head);
		}
}
