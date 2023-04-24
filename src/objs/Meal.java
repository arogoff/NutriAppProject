package src.objs;

import src.objs.Recipe;
import java.util.*;

import src.PersonalHistory;
import src.objs.*;

public class Meal extends Food {
    
    public static ArrayList<Recipe> recipeList = new ArrayList<>();
    public static double totalCalories = 0;

    public Meal(String name, String calories, String fat, String protein, String fiber, String carbs) {
        super(name, calories, fat, protein, fiber, carbs);
    }

    @Override
    public void createFood() {

    }
 
    public void addRecipe(Recipe recipe) {
       // recipeIngredients.put(recipeName, ingredients);
        for (String ingredient : recipe.ingredients.keySet()) {
            // If the ingredient is not already in stock, add it with a quantity of 0
       
        }
       
       
    }

    
    

}
