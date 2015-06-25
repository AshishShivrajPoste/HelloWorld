package com.ms.edu.linklist;
/**
 * LinkList represent the linklist with head as start point of linklist
 * @author Ashish S Poste
 */
public class Linklist {

	private Node head;
	private Node current;
	public void add(Node node){
		if(head==null){
			head = node;
			current = node;
		}
		else{
			current.setLink(node);
			current = node;
		}
	}
}
