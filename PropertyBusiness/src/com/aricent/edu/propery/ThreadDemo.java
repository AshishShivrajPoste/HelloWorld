package com.aricent.edu.propery;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class ThreadDemo implements Runnable {

   Thread t;


ThreadDemo() {
      // thread created
      t = new Thread(this, "Admin Thread");
      // set thread priority
      t.setPriority(1);
      // prints thread created
      System.out.println("thread  = " + t);
      // this will call run() function
      t.start();
   }

   public void run() {
	   List<String> listofString = new ArrayList<>();
	   try {
		this.wait(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   int count = Thread.activeCount();
	     System.out.println("currently active threads = " + count);
	    
	     Thread th[] = new Thread[count];
	     // returns the number of threads put into the array 
	     Thread.enumerate(th);
	    
	     // prints active threads
	     for (int i = 0; i < count; i++) {
	        System.out.println(i + ": " + th[i]);
	     }
      // returns the identifier of this Thread.
      System.out.println("Name = " + t.getName());
      System.out.print("Id = " + t.getId());
   }

   public static void main(String args[]) {
	  for(int i = 0;i<10;i++){
		  new ThreadDemo();
	  }
     
   }
}