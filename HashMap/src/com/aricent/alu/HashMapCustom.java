package com.aricent.alu;

import java.util.Iterator;

public class HashMapCustom<K,V> {

	private Map<K, V>[] table = null;
	private int size;
	public HashMapCustom(){
		table =new Map[16];
		size = 16;
	}
	public HashMapCustom(int size){
		table = new Map[size];
		this.size = size;
	}
	
	public V put(K key,V value){
		int hashCode = key.hashCode();
		int indexinTable = hashCode % size;
		Map map = table[indexinTable];
		if(null == map){
			Map tempMap = new Map(key, value, null);
			table[indexinTable] = tempMap;
		}else{
			Map duplicateMap = checkforDuplicateKey(map,key);
			if(duplicateMap != null)
			{
				V val = (V)duplicateMap.getValue();
				duplicateMap.setValue(value);
				return val;
			}else{
				Map tempMap = new Map(key, value, null);
				tempMap.setNext(table[indexinTable]);
				table[indexinTable] = tempMap;
				return null;
			}
		}
		return null;
	}
	private Map checkforDuplicateKey(Map map, K key) {
		Map<K,V> temp = map;
		while(temp != null){
			if(temp.getKey().equals(key)){
				return temp;
			}else{
				temp = temp.getNext();
			}
		}
		return null;
	}
	public V get(K key){
		int hashCode = key.hashCode();
		int indexinTable = hashCode % size;
		Map tempMap = table[indexinTable];
		if(tempMap == null){
			return null;
		}else{
			while(tempMap != null){
				if(tempMap.getKey() == key){
					return (V) tempMap.getValue();
				}else{
					tempMap = tempMap.getNext();
				}
			}
		}
		return null;
	}
}
