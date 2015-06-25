package com.aricent.edu.bst;

public class Node {

	private int data;
	private Node left;
	private Node right;
	private Node parent;
	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getleft() {
		return left;
	}

	public void setleft(Node left) {
		this.left = left;
	}

	public Node getright() {
		return right;
	}

	public void setright(Node right) {
		this.right = right;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
}
