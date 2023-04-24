package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.objs.GoalManager;
import src.objs.Ingredient;
import src.objs.Recipe;
import src.objs.User;
import src.utils.LoadIngredients;
import src.utils.UserUtils;

import static src.objs.ShoppingList.viewShoppingList;

public class NutriAppManager {

    public static void NutriApp(User user1) {
        User user = user1;
        // load in user's personal history + stock here as we now know what user it is

        // load in the ingredients
        ArrayList<Ingredient> ingredients = LoadIngredients.readIn();

        // load in the goal/set goalManager up
        GoalManager goalManager = new GoalManager();

        // load up the user's goal
        if(!user.getGoalType().equals("notset")){
            System.out.println(user.getGoalType());
            goalManager.setUserGoal(user.getGoalType(), Integer.parseInt(user.getDailyTarget()), Integer.parseInt(user.getGoalWeight()), user.getWorkoutTime());
            goalManager.register(user);
        }

        System.out.println("Hello " + user.getUsername() + " , Please choose an option to view data!");

        boolean run = true;
        Scanner scanner = new Scanner(System.in);

        while (run) {

            try {

                System.out.println("""
                        1 - Set Goal
                        2 - View Goal
                        3 - Update Weight
                        4 - Track Workout
                        5 - Track Meal
                        6 - View Number of Calories Left in the Day
                        7 - View Ingredients
                        8 - Add Recipe
                        9 - Get Recipe
                        10 - View Shopping List
                        11 - View History
                        12 - Logout/Exit""");

                int option = scanner.nextInt();
                scanner.nextLine();

                if (option == 1) { //Set Goal
                    System.out.println("Option 1");
                    goalManager.createGoal(user);
                } else if (option == 2) { //View goal
                    System.out.println("Option 2");
                    goalManager.getGoalInfo();
                } else if (option == 3) { //Update Weight
                    System.out.println("Option 3");
                    String newWeight = "";
                    boolean weightContinue = true;
                    while(weightContinue){
                        System.out.print("Enter your weight: ");
                        newWeight = scanner.nextLine();

                        try{
                            if(Integer.parseInt(newWeight) >= 50 && Integer.parseInt(newWeight) <= 300){
                                weightContinue = false;
                                user.setWeight(newWeight);
                                if(!user.getGoalType().equals("notset")){
                                    goalManager.checkWeight(user);
                                }else{
                                    UserUtils.updateUser(user);
                                }
                            }else{
                                System.out.println("Enter a number between 50 and 300.");
                            }
                        }catch(NumberFormatException nfe){
                            System.out.println("Enter a number between 50 and 300.");
                        }
                    }
                }else if (option == 4) { //Track workout
                    System.out.println("Option 4");
                } else if (option == 5) { //Track Meal
                    System.out.println("Option 5");
                } else if (option == 6) { //View Number of Calories Left in the Day
                    System.out.println("Option 6");
                } else if (option == 7) { //View ingredients
                    System.out.println("Option 7");
                } else if (option == 8) { //Add recipe
                    System.out.println("Option 8");
                    Recipe.initializeRecipeName();
                } else if (option == 9) { //Get recipe
                    System.out.println("Option 9");
                    Recipe.getRecipe();
                }  else if (option == 10) { //View shopping list
                    viewShoppingList();
                } else if (option == 11) { //View History
                    System.out.println("Option 11");
                } else if (option == 12) { //Logout/Exit
                    run = false;
                    System.exit(0);
                } else {
                    System.out.println("Invalid option entered, enter a number 1-12 to view data.");
                }

            }
            catch (InputMismatchException ime) {
                System.out.println("Invalid option entered, enter a number 1-11 to view data.");
                scanner.nextLine();
            }
        }
    }
}