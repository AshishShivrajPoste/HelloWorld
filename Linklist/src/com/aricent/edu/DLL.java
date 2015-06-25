package com.aricent.edu;

public class DLL {

	private String data = null;
	private DLL prev = null;
	private DLL next = null;
	
	public DLL(String data){
		data = data;
		prev = null;
		next = null;
	}
	public DLL(String data,DLL prevNode,DLL nextNode){
		data = data;
		prev = prevNode;
		next = nextNode;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public DLL getPrev() {
		return prev;
	}

	public void setPrev(DLL prev) {
		this.prev = prev;
	}

	public DLL getNext() {
		return next;
	}

	public void setNext(DLL next) {
		this.next = next;
	}

	
	
}
