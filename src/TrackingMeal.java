package src;

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
    private Map<String, List<String>> mealRecipes;
    private Map<String, List<String>> recipeIngredients;
    private Map<String, Integer> ingredientStock;
    private int dailyTargetCalories;
    private int consumedCalories;

    // Constructor to initialize variables
    public TrackingMeal(int dailyTargetCalories) {
        this.mealRecipes = new HashMap<>();
        this.recipeIngredients = new HashMap<>();
        this.ingredientStock = new HashMap<>();
        this.dailyTargetCalories = dailyTargetCalories;
        this.consumedCalories = 0;
    }

    // Method to add a recipe with its ingredients to the system
    public void addRecipe(String recipeName, List<String> ingredients) {
        recipeIngredients.put(recipeName, ingredients);
        for (String ingredient : ingredients) {
            // If the ingredient is not already in stock, add it with a quantity of 0
            if (!ingredientStock.containsKey(ingredient)) {
                ingredientStock.put(ingredient, 0);
            }
        }
       
       
    }

    // Method to add a meal with its recipes to the system
    public void addMeal(String mealName, List<String> recipes) {
        mealRecipes.put(mealName, recipes);
    }

    // Method to prepare a meal and deduct ingredients and calories from stock and daily target, respectively
    public void prepareMeal(String mealName) {
        
        List<String> recipes = mealRecipes.get(mealName);
        int calories = 0;
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

    // Main function for testing the meal tracker
    public static void main(String[] args) {
        // Initialize meal tracker with a daily target of 2000 calories
        TrackingMeal mealTracker = new TrackingMeal(2000);

    }}
