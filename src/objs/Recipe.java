package src.objs;
import java.util.*;
import java.io.*;

public class Recipe extends Food{
    public static String title;
    public static double calories;
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
        title = name;
    }

    @Override
    public void createFood() {

    }
    public static void initializeRecipeName() {

        System.out.println("Please enter the name of the recipe you would like to create: ");
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        createRecipe(input);
    }

    //hashmap is name of ingredient and then quantity of said event
    public static void createRecipe(String called){
        title= called;
        
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
        saveRecipe();

    }

    public static void saveRecipe() {
        String bigString = "Recipe: ";
        bigString += title + "\n" + ingredients;

        for (int i = 0; i < instructions.size(); i++) {
            bigString += "\nStep " + i + ": " + instructions.get(i);
        }

        try {
            FileWriter myWriter = new FileWriter("recipes.txt");
            myWriter.write(bigString);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public static String getRecipe(){
        System.out.println("Enter the name of the recipe you'd like to retrieve: ");
        Scanner scanner = new Scanner(System.in);
        
        String recipeName = scanner.nextLine();
       
        try {
            String fullText = "";
         //   File parentDir = new File("..");
            File myObj = new File("src/recipes.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> infoDump = new ArrayList<String>();
            while (myReader.hasNextLine()) {
              infoDump.add(myReader.nextLine());
            }

            int index = infoDump.indexOf("Recipe: " + recipeName);
            myReader.close();
            if(index != -1){
                int indexCounter = index+1;
                while(!infoDump.get(indexCounter).contains("Recipe:")){
                    fullText += infoDump.get(indexCounter) + "\n";
                    indexCounter++;
                } 
                 return fullText;
            } else{
                System.out.println("recipe not found");
            }
            
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        return "Couldn't find recipe for " + recipeName;

    }

    public double getRecipeCalories(){

        return calories;
    }

    public static void main(String[] args) {
        // System.out.println("In personal history...");
        System.out.println(getRecipe());
       // createRecipe("Cake");
    }
        
}
