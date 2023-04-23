package src;

import java.util.InputMismatchException;
import java.util.Scanner;
import src.objs.User;
import static src.objs.ShoppingList.viewShoppingList;
import src.PersonalHistory;
import src.objs.*;

public class NutriAppManager {

    public static void NutriApp(User user) {
        System.out.println("Hello " + user.getUsername() + " , Please choose an option to view data!");

        boolean run = true;
        Scanner scanner = new Scanner(System.in);

        while (run) {

            try {

                System.out.println("1 - Set Goal\n2 - Modify Goal\n3 - Track Workout\n4 - Track Meal\n" +
                        "5 - Add Ingredients\n6 - View Ingredients\n7 - Add Recipe\n8 - Get Recipe\n9 - View Shopping List\n" +
                        "10 - View History\n11 - Logout/Exit");

                int option = scanner.nextInt();

                if (option == 1) { //Set Goal
                    System.out.println("Option 1");
                } else if (option == 2) { //Modify goal
                    System.out.println("Option 2");
                } else if (option == 3) { //Track workout
                    System.out.println("Option 3");
                } else if (option == 4) { //Track Meal
                    System.out.println("Option 4");
                } else if (option == 5) { //Add ingredients
                    System.out.println("Option 5");
                } else if (option == 6) { //View ingredients
                    System.out.println("Option 6");
                } else if (option == 7) { //Add recipe
                    System.out.println("Option 7");
                    Recipe.initializeRecipeName();
                } else if (option == 8) { //Get recipe
                    System.out.println("Option 8");
                }  else if (option == 9) { //View shopping list
                    viewShoppingList();
                } else if (option == 10) { //View History
                    System.out.println("Option 11");
                } else if (option == 11) { //Logout/Exit
                    run = false;
                    System.out.println("Exit");
                } else {
                    System.out.println("Invalid option entered, enter a number 1-11 to view data.");
                }

            }
            catch (InputMismatchException ime) {
                System.out.println("Invalid option entered, enter a number 1-11 to view data.");
                scanner.nextLine();
            }
        }
    }
}
