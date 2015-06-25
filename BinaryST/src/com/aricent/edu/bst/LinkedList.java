package com.aricent.edu.bst;

import java.util.Stack;

public class LinkedList {

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
	public void bstInsertion(Node root,Node newNode){
		Node parent = null;
		Node x = root;
		while(x != null){
			parent = x;
			if(x.getData() >= newNode.getData()){
				x = x.getleft();
			}else{
				x = x.getright();
			}
		}
		newNode.setParent(parent);
		if(parent == null){
			root = newNode;
		}else if(newNode.getData() <= parent.getData()){
			parent.setleft(newNode);
		}else{
			parent.setright(newNode);
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
		System.out.println("Number of node in Tree are less than K");
	}
	public int BSTHeight(Node node){
		if(node == null){
			return -1;
		}
//		if(node.getleft() == null && node.getright() == null){
//			return 0;
//		}else s
		{
			int leftHeight = BSTHeight(node.getleft());
			int rightHeight = BSTHeight(node.getright());
			if(leftHeight >= rightHeight){
				return leftHeight+1;
			}else{
				return rightHeight+1;
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
	public Node inorderSucessor(Node node){
		System.out.println("Inorder of node "+node.getData());
		if(node.getright() != null){
			return minValue(node.getright());
		}
		Node parent = node.getParent();
		while(parent != null && node == parent.getright()){
				node = parent;
				parent = parent.getParent();
		}
		return parent;
	}
	public Node minValue(Node node){
		Node temp = node;
		while(temp.getleft()!=null){
			temp = temp.getleft();
		}
		return temp;
	}
	
	public Node binaryTreefromArray(int[] array,float start,float end){
		float startIndex = start;
		float lastIndex = end;
		while(start <= end){
			float f = (startIndex + lastIndex)/2;
			int mid = (int) Math.ceil((startIndex + lastIndex)/2);
			Node root = new Node(array[mid]);
			root.setleft(binaryTreefromArray(array, startIndex, mid-1));
			root.setright(binaryTreefromArray(array, mid+1, end));
			return root;
		}
		return null;
	}
	
	public void printPath(Node head,int[] path,int pathlen){
		System.out.println();
		if(head != null){
			path[pathlen] = head.getData();
			pathlen++;
		}
		if(head.getleft()==null && head.getright() == null){
			for(int i = 0 ; i < pathlen;i++){
				System.out.print(path[i]+"-->");
			}
		}else{
			printPath(head.getleft(),path,pathlen);
			printPath(head.getright(),path,pathlen);
		}
		
	}
	public static void main(String args[]){
		LinkedList bst = new LinkedList();
		
		bst.insert(20);
		bst.insert(8);
		bst.insert(22);
		bst.insert(4);
		bst.insert(12);
		bst.insert(10);
		bst.insert(14);
		
//		System.out.println(bst.inorderSucessor(head.getleft()).getData());
//		System.out.println(bst.inorderSucessor(head.getleft().getright().getleft()).getData());
//		System.out.println(bst.inorderSucessor(head.getleft().getright().getright()).getData());
//		System.out.println(bst.inorderSucessor(head.getleft()).getData());
//		
//		bst.inorderTreeWalk(head);
//		Node resultNode = bst.search(head, 65);
//		if(null != resultNode){
//			System.out.println("Search Result-->"+resultNode.getData());
//		}else{
//			System.out.println("Search Result-->"+resultNode);
//		}
//		System.out.println("MIN Node-->"+bst.minimumNode(head).getData());
//		System.out.println("MAX Node-->"+bst.maximumNode(head).getData());
//		bst.ksmallest(9, head);
//		System.out.println(bst.BSTHeight(head));
//		
////		Node root = bst.BSTtoDLL(head);
////		while (root.getleft() != null){
////			root = root.getleft();
////		}
////		System.out.println();
////		while (root != null){
////			System.out.print(" "+root.getData());
////			root = root.getright();
////		}
////		bst.inorderTreeWalksumming(head);
////		bst.inorderTreeWalk(head);
//		bst.inorderTreeWalk(head);
//		System.out.println();
//		bst.mirrorBST(head);
//		bst.inorderTreeWalk(head);
		int[] array = {1,2,3,4,5,6,7,8,9};
		int[] path = new int[10];
		bst.printPath(head, path, 0);
		bst.ksmallest(5, head);
		System.out.println(bst.BSTHeight(head));
		Node node = bst.binaryTreefromArray(array, 0, array.length-1);
		bst.inorderTreeWalk(node);
	}
}
