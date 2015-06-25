package com.aricent.edu;

public class SLL {

	private String data = null;
	private SLL next = null;
	
	public SLL(String data){
		this.data = data;
		next = null;
	}
	public SLL(String data,SLL nextNode){
		this.data = data;
		next = nextNode;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	public SLL getNext() {
		return next;
	}

	public void setNext(SLL next) {
		this.next = next;
	}
}
