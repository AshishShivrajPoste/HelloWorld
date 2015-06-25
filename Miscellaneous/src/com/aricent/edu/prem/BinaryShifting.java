package com.aricent.edu.prem;

public class BinaryShifting {

	public static void main(String args[]) {

		int capacity = 1, initialCapacity = 8;

		while (capacity < 100)

			initialCapacity=initialCapacity >> 2;

		System.out.println(capacity);

	}

}
