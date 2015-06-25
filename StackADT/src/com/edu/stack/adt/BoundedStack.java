package com.edu.stack.adt;

/***
 * BoundedStack class implements the StackADT interface to provide the Bounded implementation of Stack
 * 
 * @author 
 *
 * @param <T>
 */
public class BoundedStack<T> implements StackADT<T>{

	/**Array to hold the Elements of generic type T*/
	private T[] stackArray;
	/**Handle to the top element in stack*/
	private int top = -1;
	/**Default Constructor**/
	
	public BoundedStack(){
		stackArray =  ((T[]) new Object[16]);
	}
	
	public BoundedStack(int size){
		stackArray =  ((T[]) new Object[size]);
	}

	@Override
	public T pop() {
		if(isEmpty()){
			System.out.println("Stack is Empty");
		}else{
			T element = stackArray[top];
			top = top-1;
			return element;
		}
		return null;
	}

	@Override
	public T push(T element) {
		if(isFull()){
			System.out.println("Stack is Full!!!");
		}else{
			top = top+1;
			stackArray[top] = element;
		}
		return null;
	}

	@Override
	public Boolean isEmpty() {
		if(top == -1){
			return true;
		}
		return false;
	}

	@Override
	public Boolean isFull() {
		if(top == stackArray.length-1){
			return true;
		}
		return false;
	}

	@Override
	public T peep() {
		if(isEmpty()){
			System.out.println("Stack is Empty");
		}else{
			T element = stackArray[top];
			return element;
		}
		return null;
	}

	

}
