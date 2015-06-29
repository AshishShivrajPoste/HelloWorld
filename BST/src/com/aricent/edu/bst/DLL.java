package com.aricent.edu.bst;

import java.lang.reflect.Modifier;

public class DLL {

	private String data = null;
	private DLL prev = null;
	private DLL next = null;
	
	public DLL(String data){
		this.data = data;
		prev = null;
		next = null;
	}
	public DLL(String data,DLL prevNode,DLL nextNode){
		this.data = data;
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

	public static void main(String[] args) {
		Class myObjectClass = DLL.class;
		String className = myObjectClass.getName();
		System.out.println("CLassName-->"+className);
		
		int modifier = myObjectClass.getModifiers();
		
		System.out.println(Modifier.isPublic(modifier));
		System.out.println(Modifier.isPrivate(modifier));
		
		Package package1 = myObjectClass.getPackage();
		
		System.out.println("Ashish Package Name-->"+package1.getName());
		
		
	}
	
	
}
