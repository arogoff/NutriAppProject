package src.objs;
import java.util.*;

public class Recipe extends Food{
    public String name;
    public HashMap<String, Integer> ingredients = new HashMap<String, Integer>();
    public String instructions;
/**
 * Recipes are also a type of food. The user may create a new recipe by specifying:
    A unique name for the new recipe.
    The ingredients (and amount of each) required to make the recipe.
    The preparation instructions for the recipe.
 * 
 */

    public Recipe(String name, String calories, String fat, String protein, String fiber, String carbs) {
        super(name, calories, fat, protein, fiber, carbs);
    }

    @Override
    public void createFood() {

    }

    //hashmap is name of ingredient and then quantity of said event
    public void createRecipe(String title, HashMap<String, Integer> thingToAdd, String toDo){
        name = title;
        instructions = toDo;
        ingredients.putAll(thingToAdd);

    }

}
