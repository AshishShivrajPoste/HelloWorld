package com.ms.edu.linklist;
/**
 * Node Class will represent the node in a link list,Data and link
 * @author Ashish S Poste
 *
 */
public class Node {
	
	private Character data;
	private Node link;
	
	public Node(){};
	public Node(Character data){
		this.data = data;
	}
	public Character getData() {
		return data;
	}
	public void setData(Character data) {
		this.data = data;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}
	
	
}
