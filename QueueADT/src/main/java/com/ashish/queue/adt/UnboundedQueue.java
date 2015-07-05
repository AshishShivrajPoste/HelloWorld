package com.ashish.queue.adt;

public interface UnboundedQueue<T> extends QueueInterface<T>{

	public void enQueue(T element);


	public T deQueue();


	public Boolean isEmpty();
}
