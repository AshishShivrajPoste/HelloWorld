package com.aricent.edu.queue;

import java.util.NoSuchElementException;

import com.aricent.edu.coomon.Node;

public class QueueLinkedList<T> implements Queue<T>{

	private Node<T> front = null;
	private Node<T> rear = null;
	private int size;
	@Override
	public void enqueue(T data) {
		Node<T> node = new Node<T>(data, null);
		if(isEmpty())
		{
			front = node;
			rear = node;
		}
		else{
			rear.setNext(node);
			rear = rear.getNext();
		}
		size++;
	}

	@Override
	public T dequeue() {
		if(isEmpty()) throw new NoSuchElementException("Queue underflow");
		Node<T> node = front;
		front = front.getNext();
		if(null == front){
			rear = null;
		}
		size--;
		return node.getData();
	}
	
	public Boolean isEmpty(){
		return front == null;
	}

	public static void main(String[] args) {
		QueueLinkedList<Integer> queueLinkedList = new QueueLinkedList<Integer>();
		queueLinkedList.enqueue(1);
		queueLinkedList.enqueue(2);
		queueLinkedList.enqueue(3);
		queueLinkedList.enqueue(4);
		queueLinkedList.enqueue(5);
		
		System.out.println(queueLinkedList.dequeue());
		System.out.println(queueLinkedList.dequeue());
		System.out.println(queueLinkedList.dequeue());
		System.out.println(queueLinkedList.dequeue());
		System.out.println(queueLinkedList.dequeue());
		System.out.println(queueLinkedList.dequeue());
		System.out.println(queueLinkedList.dequeue());
		System.out.println(queueLinkedList.dequeue());
		System.out.println(queueLinkedList.dequeue());
		System.out.println(queueLinkedList.dequeue());
		
	}
}
