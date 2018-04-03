/*
 * Main.java
 *
 * TCSS 342
 * Assignment 1
 */
import java.io.*;
import java.util.*;
//It is not "Chedder", it is spelled "Cheddar"
//There is no "Sauce" only Sauces"
//The String "Veggie" is for burgers, "Veggies" is for toppings
//We call it "Cheese" not "Chesse"

/**
 * This program is the burger baron recipe builder that changes
 * ingredients and patties.
 * various types of data
 * @author Bruce Baker
 * @version April 2, 2018
 */
public class Main {
   
   /**
    * The driver for the burger program
    * @param args The command line arguments
    */
	public static void main(String[] args) {
      //testMyStack();
      //testBurger();
      Scanner inScan;
      int orderNum = 0;
      String temp = "";
      try{
         File input = new File("customer.txt");
         inScan = new Scanner(input);
         while (inScan.hasNextLine()){
            if(orderNum >= 99) {
               orderNum = 0;
            }
            temp = inScan.nextLine();
            System.out.println("Processing Order " + orderNum + ": " + temp);
            parseLine(temp);
            System.out.println("");
            orderNum++;
         }
      } catch(FileNotFoundException e) {
         System.out.println("File not found" + e);
      }

   }
   
   /**
    * Parses the line of the order and builds a burger from the
    * string as it parses and prints the burger
    * @param line the line of text from the order
    */
   public static void parseLine(String line){
      Burger myBurg;
      Scanner lineScan = new Scanner(line);
      String pattyCount = "Single";
      String pattyType = "Beef";
      boolean baron = false;
      boolean no = false;
      List<String> ommAdd = new ArrayList<String>();
      List<String> except = new ArrayList<String>();
      String temp;
      
      while(lineScan.hasNext()) {
         temp = lineScan.next();
         if(temp.equals("Double") || temp.equals("Triple")) {
           pattyCount = new String(temp);
         }else if(temp.equals("Veggie") || temp.equals("Chicken") || temp.equals("Beef")){
            pattyType = new String(temp);
         }else if(temp.equals("Baron")){
            baron = true;
         }else if(temp.equals("no")){
            no = true;
         }else if(temp.equals("but")){
            no = !(no);
         }else if(no){
            ommAdd.add(temp);
         }else if(!temp.equals("Burger") && !temp.equals("with")){
            except.add(temp);
         }
      }
      myBurg = new Burger(baron);
      if(pattyCount.equals("Double")) {
         myBurg.addPatty();
      }
      if(pattyCount.equals("Triple")){
         myBurg.addPatty();
      }
      if(!(pattyType.equals("Beef"))) {
         myBurg.changePatties(pattyType);
      }
      
      int i = 0;
      if(baron) {
         if(!(ommAdd.isEmpty())) {
           for(i = 0; i < ommAdd.size(); i++) {
               myBurg.removeCategory(ommAdd.get(i));
               myBurg.removeIngredient(ommAdd.get(i));
            }
         }
         if(!(except.isEmpty())) {
            for(i = 0; i < except.size();i++) {
               myBurg.addIngredient(except.get(i));
            }
         }
      }else {
          if(!(except.isEmpty())) {
            for(i = 0; i < except.size();i++) {
               myBurg.addIngredient(except.get(i));
               myBurg.addCategory(except.get(i));
            }
         }
         if(!(ommAdd.isEmpty())) {
            for(i = 0; i < ommAdd.size(); i++) {
               myBurg.removeIngredient(ommAdd.get(i));
            }
         }
      }
      
      System.out.println(myBurg);
      
     /* System.out.println("My count is " + pattyCount);
      System.out.println("My Patty Type is " + pattyType);
      System.out.println("My ommAdd are " + ommAdd);
      System.out.println("My exceptions are " + except);*/
   }
   
   /**
    * This metho tests all the functionalitys of the burger class
    */
   public static void testBurger(){
      Burger myBurg = new Burger(true);
      System.out.println(myBurg.toString());
      myBurg.changePatties("Veggie");
      System.out.println(myBurg.toString());
      
      System.out.println(myBurg.toString());
      myBurg.addPatty();
      System.out.println(myBurg.toString());
      myBurg.changePatties("Chicken");
      System.out.println(myBurg.toString());
      
      Burger myBurg1 = new Burger(false);
      System.out.println(myBurg1.toString());
      myBurg1.addPatty();
      myBurg1.addPatty();
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Chedder");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Pepperjack");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Mozzarella");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Mushrooms");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Lettuce");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Tomato");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Onions");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Pickle");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Ketchup");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Mustard");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Mayonnaise");
      System.out.println(myBurg1.toString());
      myBurg1.addIngredient("Baron-Sauce");
      System.out.println(myBurg1.toString());
      
      Burger myBurg2 = new Burger(true);
      //System.out.println(myBurg2.toString());
      myBurg2.addCategory("Cheese");
      //System.out.println(myBurg2.toString());
      myBurg2.addCategory("Veggies");
      //System.out.println(myBurg2.toString());
      myBurg2.addCategory("Sauces");
      System.out.println(myBurg2.toString());
      myBurg2.removeIngredient("Chedder");
      System.out.println(myBurg2.toString());
      myBurg2.removeCategory("Sauces");
      System.out.println(myBurg2.toString());
      myBurg2.removeCategory("Cheese");
      System.out.println(myBurg2.toString());
      myBurg2.removeCategory("Veggies");
      System.out.println(myBurg2.toString());
      


   }
   
   /**
    * This method tests all the functionalities of the
    * general stack in the MyStack class
    */
   public static void testMyStack() {
      MyStack<Integer> myS1 = new MyStack<Integer> ();
      myS1.push(1);
      myS1.push(2);
      myS1.push(3);
      myS1.push(4);
      System.out.println(myS1.peek().toString());
      myS1.pop();
      System.out.println(myS1.toString());
      myS1.pop();
      System.out.println(myS1.toString());
      myS1.pop();
      System.out.println(myS1.toString());
      myS1.pop();
      System.out.println(myS1.toString());
      myS1.pop();
      System.out.println(myS1.toString());
      
      MyStack<String> myS2 = new MyStack<String> ();
      myS2.push("1");
      myS2.push("2");
      myS2.push("3");
      myS2.push("4");
      System.out.println(myS2.peek().toString());
      System.out.println(myS2.size());
      myS2.pop();
      System.out.println(myS2.toString());
      System.out.println(myS2.size());
      myS2.pop();
      System.out.println(myS2.toString());
      System.out.println(myS2.size());
      myS2.pop();
      System.out.println(myS2.toString());
      System.out.println(myS2.size());
      myS2.pop();
      System.out.println(myS2.toString());
      System.out.println(myS2.size());
      myS2.pop();
      System.out.println(myS2.toString());
      System.out.println(myS2.size());
   }
   
}
