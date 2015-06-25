package com.aricent.alu;

public class HashMapRedined<K,V> {

	private Map[] table = null;
	private int sizeofmap;
	public HashMapRedined(int size){
		table = new Map[size];
		this.sizeofmap = size;
	}
	public void putModified(K Key,V value){	
		int hashindex = Key.hashCode()%sizeofmap;
		Map map = new Map(Key, value, null);
		if(table[hashindex]==null){
			table[hashindex] = map;
		}else{
			Map tempmap = table[hashindex];
			while(tempmap.getNext()!=null){
				tempmap = tempmap.getNext();
			}
			tempmap.setNext(map);
		}
		
	}
	public Object getModified(K key){
		int hashindex = key.hashCode()%sizeofmap;
		Map map = table[hashindex];
		while(map != null){
			if(key == map.getKey())
			{
				return map.getValue();
			}
			map = map.getNext();
		}
		return null;
	}
	
}
