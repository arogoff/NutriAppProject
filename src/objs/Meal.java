package src.objs;

import src.objs.Recipe;
import java.util.*;

import src.PersonalHistory;
import src.objs.*;

public class Meal extends Food {
    
    public static ArrayList<Recipe> recipeList = new ArrayList<>();
    public static double totalCalories = 0;
    public static String mealName ;
    public Meal(String name, String calories, String fat, String protein, String fiber, String carbs) {
        super(name, calories, fat, protein, fiber, carbs);
    }

    @Override
    public void createFood() {

    }
 //save meals to personal history
    public static Meal createMeal(String name, List<Recipe> recipes){
        mealName = name;
        recipes = recipeList;
        return null;
    }

    public void addRecipe(Recipe recipe) {
       // recipeIngredients.put(recipeName, ingredients);
       
       
       
    }

    
    

}
