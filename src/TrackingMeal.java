package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import src.PersonalHistory;

import src.objs.*;
/* Suggestions for this file
* The Meal class should have a method to add recipes to the meal.
* The Recipe class should have a list of ingredients, and a method to add ingredients to the recipe.
* The Ingredient class should have a field for the current stock, and a method to deduct the ingredient from the stock when it is used in a recipe.
* The TrackingMeal class should have a method to guide the user through the steps to prepare each recipe in the meal.
* The TrackingMeal class should have a method to check if the ingredients are in stock before preparing the meal, and warn the user if they are not.
* The TrackingMeal class should have a method to calculate the total calories in the meal and deduct them from the user's daily target.*/
public class TrackingMeal {

    // Define variables to track meals, recipes, and ingredients
    private static Map<String, List<Recipe>> meals;
    private Map<String, List<String>> recipeIngredients;
    public static ArrayList<Recipe> recipes = new ArrayList<>();
    
    private Map<String, Integer> ingredientStock;
    private int dailyTargetCalories;
    private int consumedCalories;

    // Constructor to initialize variables
    public TrackingMeal(int dailyTargetCalories) {
        this.meals = new HashMap<>();
        this.recipeIngredients = new HashMap<>();
        this.ingredientStock = new HashMap<>();
        this.dailyTargetCalories = dailyTargetCalories;
        this.consumedCalories = 0;
    }

    public static Recipe getRecipe(String recipeName){
       return Recipe.getRecipeForMeal(recipeName);
    }

    //Check if recipes.txt has any recipes with this user's username attached
    public static String createMeal(User anon){
        //check if recipes.txt is empty
        System.out.println("You need recipes to create a meal.");

        //if it isnt empty, then proceed to select recipe(s) to create meal with
        try {
            String fullText = "";
        //   File parentDir = new File("..");
            File myObj = new File("src/recipes.txt");
            FileReader fr = new FileReader(myObj);  //Creation of File Reader object
            BufferedReader br = new BufferedReader(fr); 
            Scanner myReader = new Scanner(myObj);
            String s;    
            ArrayList<String> infoDump = new ArrayList<String>();
            while ((s=br.readLine())!=null) {
                
                if(s.contains("Recipe: ")){
                    infoDump.add(s);
                }
            
            }
            myReader.close();
            String bigString = "You have the following recipes:\n";
            for (String string : infoDump) {
                bigString += string + "\n";
            }

            System.out.println("Which recipe(s) do you want to add to this meal? Type exit when finished.");
            Scanner scanner = new Scanner(System.in);
        //Take in the ingredients and how many of each (saved in hashmap in the format of <IngredientName, IngredientQuantity>)
            String option = scanner.nextLine();
            List<Recipe> recipesToAdd = new ArrayList<>();
            while(!option.equals("exit")){
               recipesToAdd.add(Recipe.getRecipeForMeal(option));
               // ingredientAmt.put(things[0], Double.parseDouble(things[1]));
                option = scanner.nextLine();
            }

            return bigString;
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return "No recipes found.";

    
    }
    //check if the user's personal history has prepared any meals before
    public static String mealsExist(User anon){

       // PersonalHistory.mealsExist(anon);
        return null;
        
    }



    // Method to add a recipe with its ingredients to the system
    public void addRecipe(Recipe recipe) {
       // recipeIngredients.put(recipeName, ingredients);
        Recipe.getRecipe();
        for (Ingredient ingredient : recipe.ingredients.keySet()) {
             // If the ingredient is not already in stock, add it with a quantity of 0
             if (!ingredientStock.containsKey(ingredient.name)) {
                ingredientStock.put(ingredient.name, 0);
            }
        }
       
    }

    // Method to add a meal with its recipes to the system
    public void addMeal(String mealName, List<Recipe> recipes) {
        meals.put(mealName, recipes);
        System.out.println("Meal created.");
        //mealRecipes.put(mealName, recipes);
    }

    // Method to prepare a meal and deduct ingredients and calories from stock and daily target, respectively
    public String prepareMeal(String mealName) {
        
        List<Recipe> recipes = meals.get(mealName);
        int calories = 0;

        for (Recipe recipe : recipes) {
            for (Ingredient ingredient : recipe.ingredients.keySet()) {
              // If the ingredient is not in stock, throw an exception
              if (!ingredientStock.containsKey(ingredient.name)) {
                return "Ingredient not in stock: " + ingredient.name;
            }  

             // If there is not enough of the ingredient in stock, throw an exception
             if (ingredientStock.get(ingredient.name) <= 0) {
                return "Not enough of ingredient in stock: " + ingredient.name;
            }
            // Deduct the ingredient from stock
            ingredientStock.put(ingredient.name, ingredientStock.get(ingredient.name) - 1);
            }

        }

         // Add the total meal calories to the consumed calories
         consumedCalories += calories;
         // If the consumed calories exceed the daily target, throw a warning
         if (consumedCalories > dailyTargetCalories) {
             System.out.println("Warning: Exceeded daily target calories by " + (consumedCalories - dailyTargetCalories));
         }
         PersonalHistory.addMeal(mealName, calories);

      return "";
         /** 
        for (String recipe : recipes) {
            List<String> ingredients = recipeIngredients.get(recipe);
            for (String ingredient : ingredients) {
                // If the ingredient is not in stock, throw an exception
                if (!ingredientStock.containsKey(ingredient)) {
                    throw new RuntimeException("Ingredient not in stock: " + ingredient);
                }
                // If there is not enough of the ingredient in stock, throw an exception
                if (ingredientStock.get(ingredient) <= 0) {
                    throw new RuntimeException("Not enough of ingredient in stock: " + ingredient);
                }
                // Deduct the ingredient from stock
                ingredientStock.put(ingredient, ingredientStock.get(ingredient) - 1);
            }
            // Add the calories for the recipe to the total meal calories
            calories += getRecipeCalories(recipe);
        }
        // Add the total meal calories to the consumed calories
        consumedCalories += calories;
        // If the consumed calories exceed the daily target, throw a warning
        if (consumedCalories > dailyTargetCalories) {
            System.out.println("Warning: Exceeded daily target calories by " + (consumedCalories - dailyTargetCalories));
        }
        PersonalHistory.addMeal(mealName, calories);
*/
    }

    // Method to get the calories for a recipe based on its ingredients
    private int getRecipeCalories(String recipe) {
        int calories = 0;
        List<String> ingredients = recipeIngredients.get(recipe);
        for (String ingredient : ingredients) {
            calories += getIngredientCalories(ingredient);
        }
        return calories;
    }

    // Method to get the calories for an ingredient
    private int getIngredientCalories(String ingredient) {
        // Replace with actual calorie lookup for ingredient
        return 0;
    }

    public static void displayMeals(){
        for (String recipe : meals.keySet()) {
            for (Recipe recipez : meals.get(recipe)) {
                System.out.println(recipez.name);
                System.out.println(recipez.instructions);
            }
        }
       
    }
    // Main function for testing the meal tracker
    public static void main(String[] args) {
        // Initialize meal tracker with a daily target of 2000 calories
        TrackingMeal mealTracker = new TrackingMeal(2000);

       mealTracker.recipes.add(getRecipe("Banana Cake"));
        mealTracker.meals.put("lunch",recipes);
        mealTracker.displayMeals();
        mealTracker.prepareMeal("lunch");
    }
}
