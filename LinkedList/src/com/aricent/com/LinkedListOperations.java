package com.aricent.com;


public class LinkedListOperations {
	
	public  SLL revesreHead = null;
	private SLL reverseLinklist(SLL head){
		SLL prev = null;
		SLL current = head;
		SLL next = null;
		while(current != null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
	}
	private SLL reverseKlinklist(SLL head,int k){
		SLL prev = null;
		SLL current = head;
		SLL next = null;
		int count = 0;
		while(count < k && current != null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count++;
		}
		if(current != null){
			head.setNext(reverseKlinklist(current, k));
		}
		return prev;
	}
	private SLL reverseEveryKNodeLinklist(SLL head,int k){
		SLL prev = null;
		SLL current = head;
		SLL next = null;
		int count = 0;
		while(current != null && count < k) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count++;
		}
		if(head != null){
			head.setNext(current);
		}
		count = 1;
		while(current != null && count < k){
			current = current.getNext();
			count++;
		}
		if(current != null){
			current.setNext(reverseEveryKNodeLinklist(current.getNext(), k));
		}
		return prev;
	}
	private void printLinklist(SLL node){
		SLL tempNode = node;
		while(tempNode != null){
			System.out.print(" "+tempNode.getData());
			tempNode = tempNode.getNext();
		}
	}
	public SLL reverselinklist1pointer(SLL head){
		
		SLL p = head;
		if(p.getNext().getNext() != null){
			reverselinklist1pointer(p.getNext());
			
		}
		if(revesreHead == null){
			revesreHead = p.getNext();
		}
		p.getNext().setNext(p);
		p.setNext(null);
		return revesreHead;
		
	}
	
	public SLL reverselinklist1pointer1(SLL head){
		
		SLL p = head;
		SLL result = null;
		if(p.getNext() == null){
			return p;
		}else{
			result	= reverselinklist1pointer1(p.getNext());
		 	p.getNext().setNext(p);
			p.setNext(null);
		}
		return result;
	}


	
	public static void main(String args[]){
		LinkedListOperations linkedListOperations = new LinkedListOperations();
		SLL head = new SLL("10", new SLL("30", new SLL("12", new SLL("21", new SLL("56", new SLL("98", null))))));
//		
//		System.out.println("Original link list-->");
//		linkedListOperations.printLinklist(head);
//		SLL reverseNode = linkedListOperations.reverseLinklist(head);
//		System.out.println("Reversed link list-->");
//		linkedListOperations.printLinklist(reverseNode);
		SLL result = linkedListOperations.reverselinklist1pointer1(head);
		System.out.println("Original link list Changed-->");
		linkedListOperations.printLinklist(result);
		SLL reverseKNode = linkedListOperations.reverseKlinklist(head, 2);
		System.out.println("Reversed k link list-->");
		linkedListOperations.printLinklist(reverseKNode);
		
	}
}
