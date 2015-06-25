package com.edu.knapsack;

import java.util.List;
import java.util.Vector;



public class Node {

        public int level;
        public double size, value, bound;
        public List contains;
        public  Node( ) {
             level = 0;
             size = 0.0;
             value = 0.0;
             bound = 0.0;
             contains = null;
        }
        public void copyList (List contains2) {
             if ( contains2 == null || contains2.isEmpty( ) )
                  contains = new Vector( );
             else
                  contains = new Vector(contains2);
        }
        public void add (int index) {
            contains.add(new Integer(index) );
        }

 }
