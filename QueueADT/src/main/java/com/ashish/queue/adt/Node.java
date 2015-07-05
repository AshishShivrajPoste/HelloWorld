package com.ashish.queue.adt;

public class Node<E>{
        private E itemData;
        private Node next;
		public E getItemData() {
			return itemData;
		}
		public void setItemData(E itemData) {
			this.itemData = itemData;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
        
        
}
