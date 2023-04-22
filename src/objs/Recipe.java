package src.objs;
import java.util.*;


public class Recipe extends Food{
    public static String name;
    public static HashMap<String, Double> ingredients = new HashMap<String, Double>();
    public static ArrayList<String> instructions = new ArrayList<String>();
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
    public static void createRecipe(String title){
        name = title;
        
        System.out.println("Create the " + title + " recipe! Enter the ingredients in the format of 'Ingredient name';'quantity'. Type 'exit' to finish.  ");
        Scanner scanner = new Scanner(System.in);
        
        String option = scanner.nextLine();
        while(!option.equals("exit")){
            String things[] = option.split(";");
            ingredients.put(things[0], Double.parseDouble(things[1]));
            option = scanner.nextLine();
        }
       System.out.println(ingredients);
     
        System.out.println("Enter the steps for the recipe one at a time. Enter 'exit' when done. ");
        option = scanner.nextLine();
        while(!option.equals("exit")){
            instructions.add(option);
            option = scanner.nextLine();
        }
        System.out.println("Recipe saved!");
    }

    public static void main(String[] args) {
        // System.out.println("In personal history...");

       // createRecipe("Cake");
    }
        
}
