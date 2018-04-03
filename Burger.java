/*
 * Burger.java
 *
 * TCSS 342
 * Assignment 1
 */


/**
 * This program is the burger baron recipe builder that changes
 * ingredients and patties.
 * various types of data
 * @author Bruce Baker
 * @version April 2, 2018
 */
public class Burger{
   /**
    * This stack holds the ingridients which can appear on a burger
    */
   MyStack<Ingredient> myBurger = new MyStack<Ingredient>();
   /**
    * This string contains the curret type of patty in the burger
    */
   String myPattyType;
   /**
    * Constructor for the burger, it initializes a burger with all ingredients
    * present in the stack, but depending on the order, they will either be all true
    * or only true for buns and a patty.
    * @param theWorks determines if the burger is a baron burger or not
    */
   Burger(boolean theWorks) {
      myPattyType = "Beef";
      if (theWorks == true) {   
         myBurger.push(new Ingredient("Bun","Bread", true));
         myBurger.push(new Ingredient("Ketchup", "Sauce", true));
         myBurger.push(new Ingredient("Mustard", "Sauce", true));
         myBurger.push(new Ingredient("Mushrooms", "Veggies", true));
         myBurger.push(new Ingredient(myPattyType, "Patty", true));
         myBurger.push(new Ingredient("Cheddar", "Cheese", true));
         myBurger.push(new Ingredient("Mozzarella", "Cheese", true));
         myBurger.push(new Ingredient("Pepperjack", "Cheese", true));
         myBurger.push(new Ingredient(myPattyType, "Patty", false));
         myBurger.push(new Ingredient(myPattyType, "Patty", false));
         myBurger.push(new Ingredient("Onions", "Veggies", true));
         myBurger.push(new Ingredient("Tomato"," Veggies", true));
         myBurger.push(new Ingredient("Lettuce", "Veggies", true));
         myBurger.push(new Ingredient("Baron-Sauce", "Sauce", true));
         myBurger.push(new Ingredient("Mayonnaise", "Sauce", true));
         myBurger.push(new Ingredient("Bun", "Bread", true));
         myBurger.push(new Ingredient("Pickle", "Veggies", true));
      } else {
         myBurger.push(new Ingredient("Bun","Bread", true));
         myBurger.push(new Ingredient("Ketchup", "Sauce", false));
         myBurger.push(new Ingredient("Mustard", "Sauce", false));
         myBurger.push(new Ingredient("Mushrooms", "Veggies", false));
         myBurger.push(new Ingredient(myPattyType, "Patty", true));
         myBurger.push(new Ingredient("Cheddar", "Cheese", false));
         myBurger.push(new Ingredient("Mozzarella", "Cheese", false));
         myBurger.push(new Ingredient("Pepperjack", "Cheese", false));
         myBurger.push(new Ingredient(myPattyType, "Patty", false));
         myBurger.push(new Ingredient(myPattyType, "Patty", false));
         myBurger.push(new Ingredient("Onions", "Veggies", false));
         myBurger.push(new Ingredient("Tomato"," Veggies", false));
         myBurger.push(new Ingredient("Lettuce", "Veggies", false));
         myBurger.push(new Ingredient("Baron-Sauce", "Sauce", false));
         myBurger.push(new Ingredient("Mayonnaise", "Sauce", false));
         myBurger.push(new Ingredient("Bun", "Bread", true));
         myBurger.push(new Ingredient("Pickle", "Veggies", false));
      }
   }
   /**
    * Changes the patty type in burger
    * @param pattyType the patty type that we shall change our burger to
    */
   void changePatties(String pattyType) {
      myPattyType = pattyType;
      MyStack<Ingredient> temp = new MyStack<Ingredient>();
      while(!(myBurger.isEmpty())) {
         temp.push(myBurger.pop());
      }
      while(temp.isEmpty() == false) {
         if(temp.peek().myCat.equals("Patty")){
            temp.peek().myIng = myPattyType;
         }
         myBurger.push(temp.pop());
      } 
   }
   /**
    * Changes a flag on the First False Burger to true
    */
   void addPatty() {
      MyStack<Ingredient> temp = new MyStack<Ingredient>();
      while(!(myBurger.isEmpty())) {
         if(myBurger.peek().myCat.equals("Patty") && myBurger.peek().onBurg == false ){
            myBurger.peek().onBurg = true;
            break;
         } else {
            temp.push(myBurger.pop());
         }
      }
      while(temp.isEmpty() == false) {
         myBurger.push(temp.pop());
      }
   } 
   /**
    * Adds a category of ingredient by calling the add ingriedient
    * for each of the mathing categories
    * @param type Adds the requested category of ingriedient into the burger
    */
   void addCategory(String type){
      if (type.equals("Cheese")){
         this.addIngredient("Cheddar");
         this.addIngredient("Mozzarella");
         this.addIngredient("Pepperjack");
      } else if (type.equals("Veggies")){
         this.addIngredient("Lettuce");
         this.addIngredient("Tomato");
         this.addIngredient("Onions");
         this.addIngredient("Pickle");
         this.addIngredient("Mushrooms");
      }else if (type.equals("Sauce")){
         this.addIngredient("Ketchup");
         this.addIngredient("Mustard");
         this.addIngredient("Mayonnaise");
         this.addIngredient("Baron-Sauce");
      }
   }
   /**
    * removes a requested category of ingriedient from the burger
    * by flipping their flags to true
    * @param type the category of ingiredient to be removes
    */
   void removeCategory(String type){
      if (type.equals("Cheese")){
         this.removeIngredient("Cheddar");
         this.removeIngredient("Mozzarella");
         this.removeIngredient("Pepperjack");
      } else if (type.equals("Veggies")){
         this.removeIngredient("Lettuce");
         this.removeIngredient("Tomato");
         this.removeIngredient("Onions");
         this.removeIngredient("Pickle");
         this.removeIngredient("Mushrooms");
      }else if (type.equals("Sauce")){
         this.removeIngredient("Ketchup");
         this.removeIngredient("Mustard");
         this.removeIngredient("Mayonnaise");
         this.removeIngredient("Baron-Sauce");
      }
   }
   /**
    * Flips the flag of the ingriedient on the burger to true
    * if it is present on the burger
    * @param type the ingriedient to be added
    */
   void addIngredient(String type) {
      MyStack<Ingredient> temp = new MyStack<Ingredient>();
      while(!(myBurger.isEmpty())) {
         if(myBurger.peek().myIng.equals(type) && myBurger.peek().onBurg == false ){
            myBurger.peek().onBurg = true;
            break;
         } else {
            temp.push(myBurger.pop());
         }
      }
      while(temp.isEmpty() == false) {
         myBurger.push(temp.pop());
      }
   }
   /**
    * Removes the requested ingriedient from the burger
    * @param type the ingriedient to be removed
    */
   void removeIngredient(String type) {
      MyStack<Ingredient> temp = new MyStack<Ingredient>();
      while(!(myBurger.isEmpty())) {
         if(myBurger.peek().myIng.equals(type) && myBurger.peek().onBurg == true ){
            myBurger.peek().onBurg = false;
            break;
         } else {
            temp.push(myBurger.pop());
         }
      }
      while(temp.isEmpty() == false) {
         myBurger.push(temp.pop());
      }
   }

   /**
    * returns a string of the ingriedient on the burger which is anything
    * that has a True ingridient
    * @return the burgers True ingriedients
    */
   public String toString() {
      String myString = new String("[");
      MyStack<Ingredient> temp = new MyStack<Ingredient>();
      while(!(myBurger.isEmpty())) {
         if(myBurger.peek().onBurg){
            myString = myString + myBurger.peek().myIng + ", ";
         }
         temp.push(myBurger.pop());
      }
      while(temp.isEmpty() == false) {
         myBurger.push(temp.pop());
      }
      myString = myString.substring(0,myString.length() - 2);
      myString = myString + "]";
      return myString;
   }

         
   /**
    * The ingredients of the burger contains 3 properties
    * which are the ingriedient, it's category, and whether the
    * ingriedient is on the burger
    */
   private class Ingredient {
      /**
      * The ingriedient that is on the burger
      */
      String myIng;
      /**
      * The category of ingriedient
      */
      String myCat;
      /**
      * The status of the ingriedient on the burger
      */
      boolean onBurg;
      /**
      * The constructor for the ingridient
      * @param theIng assigns a string to myIngredient
      * @param theCat assigns the category of ingredient
      * @param theRecipe Assigns the boolean to true or false if the recipe calls for it
      */
      Ingredient(String theIng, String theCat, boolean theRecipe){
         myIng = theIng;
         myCat = theCat;
         onBurg = theRecipe;
      }
      /**
      * Returns the ingredient field as a string
      * @return the ingredient string
      */
      public String toString() {
         return myIng;
      }
      
   }

   
}


