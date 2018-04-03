/*
 * MyStack.java
 *
 * TCSS 342
 * Assignment 1
 */

import java.util.*;

/**
 * This program is my implementation of a
 * generic stack object thats uses nodes to pop and push
 * various types of data
 * @author Bruce Baker
 * @version April 2, 2018
 */
public class MyStack<Type>{
   /**
   * Keeps track of the size of the stack
   */
   private int count;
   /**
    * A Node that contains no data to simulate
    * the bottoms of the stack
    */
   private Node<Type> top;
   /**
    * Constructor for the stack, it initializes
    * the top element as an empty node and the count as 0
    */
   public MyStack() {
      count = 0;
      top = null;
   }
   
   /**
    * Answers whether the stack is empty or not
    *
    *@return Returns true if the stack is empty
    */
   public boolean isEmpty() {
      return count == 0;
   }
   
   /**
    * Adds a new element to the stack
    *
    *@param item The element to be added in
    */
   void push(Type item) {
      top = new Node<Type>(item, top);
      count++;
   }
   /**
    * takes off the top element to the stack
    *
    *@return The element that was just removed
    */
   public Type pop() {
      Node<Type> temp = null;
      if(count != 0) {
            temp = top;
            top = top.nextNode;
            count--;
            return temp.data;
         }
      return null;
   }
   
   /**
    * Tells you what is on top of the stack
    *
    *@return item The element to be added in
    */
   public Type peek() {
      return top.data;
   }
   
   /**
    * Returns the size of the stack
    *
    *@return the amount of elements in the stack
    */
   int size(){
      return count;
   }
   
   /**
    * Returns the stacks contents as a string.
    *
    *@return the string of elements in the stack
    */

   public String toString() {
      Node<Type> temp = top;
      String theString = "[";
      if( temp != null) {
         theString = theString + temp.data.toString();
         temp = temp.nextNode;
      }

      
      while (temp != null) {
         theString = theString+ ", " + temp.data.toString();
         temp = temp.nextNode;
         }
      theString = theString + "]";
      return theString;
      
   }
   
   /**
    * A node element that holds the data
    * and the next node in the stack
    *
    */

   private class Node<Type>{
      /**
       * The data in the node
       */
      Type data;
      
      /**
       * The next node in the stack
       */
      Node<Type> nextNode;
      
      /**
       * The constructor for a node.
       * @param item The data to be put into the node
       * @param next The previous node in the stack
       */
      public Node(Type item, Node<Type> next){
         data = item;
         nextNode = next;
      }
   }
   
   


}

