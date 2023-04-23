package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.objs.GoalManager;
import src.objs.Ingredient;
import src.objs.User;
import src.utils.LoadIngredients;

import static src.objs.ShoppingList.viewShoppingList;

public class NutriAppManager {

    public static void NutriApp(User user) {
        // load in user's personal history + stock here as we now know what user it is

        // load in the ingredients
        ArrayList<Ingredient> ingredients = LoadIngredients.readIn();

        // load in the goal/set goalManager up
        GoalManager goalManager = new GoalManager();
        // load up the user's goal
        if(!user.getGoalType().equals("notset")){
            goalManager.setUserGoal(user.getGoalType(), Integer.parseInt(user.getDailyTarget()), Integer.parseInt(user.getGoalWeight()));
        }

        System.out.println("Hello " + user.getUsername() + " , Please choose an option to view data!");

        boolean run = true;
        Scanner scanner = new Scanner(System.in);

        while (run) {

            try {

                System.out.println("""
                        1 - Set Goal
                        2 - View Goal
                        3 - Track Workout
                        4 - Track Meal
                        5 - View Number of Calories Left in the Day
                        6 - View Ingredients
                        7 - Add Recipe
                        8 - Get Recipe
                        9 - View Shopping List
                        10 - View History
                        11 - Logout/Exit""");

                int option = scanner.nextInt();

                if (option == 1) { //Set Goal
                    System.out.println("Option 1");
                    goalManager.createGoal(user);
                } else if (option == 2) { //View goal
                    System.out.println("Option 2");
                    goalManager.getGoalInfo();
                } else if (option == 3) { //Track workout
                    System.out.println("Option 3");
                } else if (option == 4) { //Track Meal
                    System.out.println("Option 4");
                } else if (option == 5) { //View Number of Calories Left in the Day
                    System.out.println("Option 5");
                } else if (option == 6) { //View ingredients
                    System.out.println("Option 6");
                } else if (option == 7) { //Add recipe
                    System.out.println("Option 7");
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
