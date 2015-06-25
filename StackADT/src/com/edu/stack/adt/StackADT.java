package com.edu.stack.adt;

/***
 * Interface StackADT provide the declaration for the method which a stack Class should Implement
 * @author
 *
 * @param <T>
 */
public interface StackADT<T> {

	/** Pop a Element of generic type T from the Stack*/
	public T pop();
	/** Push a Element of generic type T into the Stack*/
	public T push(T element);
	/** Check if stack is Empty*/
	public Boolean isEmpty();
	/** Check if stack if Full*/
	public Boolean isFull();
	/** Peep into the top  Element of generic type T of the Stack*/
	public T peep();
}
