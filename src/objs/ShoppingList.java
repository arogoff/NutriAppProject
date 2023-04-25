package src.objs;

//imports for file manipulation
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;



public class ShoppingList {
    public static void viewShoppingList(HashMap<String, Ingredient> ingredients, String username) { //Function to read shopping list, create shopping list, and modify shopping list
        try { //Create the file
            BufferedWriter br = new BufferedWriter(new FileWriter(new File("src/databases" + username + "_shoppingList.txt")));
            for (String i : ingredients.keySet()) {
                if (ingredients.get(i).getStock() < 3) { //Adds to shopping list if any ingredient in their house is low/out of stock
                    br.write((3-ingredients.get(i).getStock()) + " - " + ingredients.get(i).ingDesc() + "\n");
                    System.out.println("" + ingredients.get(i).getStock() + "\n");
                }
            }
            System.out.println("Shopping list created! Would you like to see it? Y/N");
            Scanner scanner = new Scanner();


            br.close();
        }
        catch (IOException e) { //In case of an error
            System.out.println("An error occurred, please try writing to the file again.");
            e.printStackTrace();
        }
    }
}
