package com.aricent.edu.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

	public static void main(String[] args) {
		
		
	CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<String>();
	list1.add("f1");
	list1.add("f2");
	list1.add("f3");
 	GL2FileLister gl2FileLister1 = new GL2FileLister(list1);
 	
	
 	CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<String>();
	list2.add("f1");
	list2.add("f5");
	list2.add("f2");
 	GL2FileLister gl2FileLister2 = new GL2FileLister(list2);
 	
 	CopyOnWriteArrayList<String> list3 = new CopyOnWriteArrayList<String>();
	list3.add("f1");
	list3.add("f4");
	list3.add("f6");
 	GL2FileLister gl2FileLister3 = new GL2FileLister(list3);
 	
 	
 	CopyOnWriteArrayList<String> list4 = new CopyOnWriteArrayList<String>();
	list4.add("f2");
	list4.add("f7");
	list4.add("f8");
 	GL2FileLister gl2FileLister4 = new GL2FileLister(list4);
 	
 	
 	Thread t1 = new Thread(gl2FileLister1);
 	Thread t2 = new Thread(gl2FileLister2);
 	Thread t3 = new Thread(gl2FileLister3);
 	Thread t4 = new Thread(gl2FileLister4);
 	
 	t1.start();
 	t2.start();
 	t3.start();
 	t4.start();
 	
 	try {
		t1.join();
		t2.join();
	 	t3.join();
	 	t4.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	;
 	
	}
}
