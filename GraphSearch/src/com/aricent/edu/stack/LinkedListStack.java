package com.aricent.edu.stack;

import com.aricent.edu.coomon.Node;

public class LinkedListStack<T> implements Stack<T> {

	private Node<T> top = null;
	
	@Override
	public void push(T t) {
		Node<T> node = new Node<T>(t, null);
		if(isEmpty()){
			top = node;
		}else{
			node.setNext(top);
			top = node;
		}
	}

	@Override
	public T pop() {
		if(!isEmpty()){
			Node<T> node = top;
			top = top.getNext();
			return node.getData();	
		}
		return null;
		
	}
	public Boolean isEmpty(){
		return top == null;
	}

	public static void main(String[] args) {
		LinkedListStack<Integer> stack =  new LinkedListStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		stack.push(6);
		stack.push(6);
		stack.push(6);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
}