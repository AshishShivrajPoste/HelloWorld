package com.aricent.edu.queue;

public interface Queue<T> {

	public void enqueue(T t);
	public T dequeue();
}
