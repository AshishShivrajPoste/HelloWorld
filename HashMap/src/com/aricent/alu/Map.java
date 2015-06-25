package com.aricent.alu;

public class Map<K,V> {

		private K key;
		private V Value;
		private Map next;
		
		public Map(K key,V value,Map next){
			this.key = key;
			this.Value = value;
			this.next = next;
		}
		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return Value;
		}
		public void setValue(V value) {
			Value = value;
		}
		public Map getNext() {
			return next;
		}
		public void setNext(Map next) {
			this.next = next;
		}
		
}
