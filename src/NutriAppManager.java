package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<String, Ingredient> ingredients = LoadIngredients.readIn(user.getUsername());

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
                        5 - View All Ingredients
                        6 - View Ingredient Info
                        7 - Update Ingredient Stock
                        9 - Add Recipe
                        10 - Get Recipe
                        11 - View Shopping List
                        12 - View History
                        13 - Logout/Exit""");

                int option = scanner.nextInt();
                scanner.nextLine();

                if (option == 1) { //Set Goal
                    goalManager.createGoal(user);
                } else if (option == 2) { //View goal
                    goalManager.getGoalInfo();
                } else if (option == 3) { //Update Weight
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
                    TrackingWorkout.workoutVisual(user);
                } else if (option == 5) { //Track Meal
                    System.out.println("""
                        What would you like to do today?
                            10 - Create Meal
                            11 - Prepare Meal
                            """);
                        Scanner scan = new Scanner(System.in);
        
                    int input = scan.nextInt();
                    if(input == 10 ){ //create meal
                        TrackingMeal.createMeal(user);
                    } else if (input == 11) { //prepare meal
                        TrackingMeal.mealsExist(user);
                    } else {
                        System.out.println("Sorry, that's not an option.");
                    }
                }else if (option == 6) { //View all ingredients
                    for (String i : ingredients.keySet()) {
                        System.out.println(ingredients.get(i).getInfo());
                    }
                } else if (option == 7) {
                    boolean repeat = true;

                    while(repeat) {
                        System.out.println("Enter Ingredient ID:\n");
                        String id = scanner.nextLine();

                        if (ingredients.containsKey(id)) {
                            repeat = false;
                            System.out.println(ingredients.get(id).getInfo());
                        }else {
                            System.out.println("Ingredient ID does not exist");
                        }
                    }
                }else if (option == 8) {
                    boolean repeat = true;

                    while(repeat) {
                        System.out.println("Enter Ingredient ID:\n");
                        String id = scanner.nextLine();

                        if (ingredients.containsKey(id)) {
                            repeat = false;
                            boolean stockRepeat = true;
                            while(stockRepeat) {
                                try {
                                    System.out.println("Enter the number you want to increment the stock by.\n");
                                    int num = scanner.nextInt();

                                    if(num > 0) {
                                        stockRepeat = false;
                                        Ingredient i = ingredients.get(id);
                                        i.setStock(i.getStock() + num);
                                        ingredients.replace(id, i);
                                        LoadIngredients.updateStock(i, user.getUsername());
                                    }else {
                                        System.out.println("You entered a number that is less than 0.");
                                    }
                                } catch (NumberFormatException nfe) {
                                    System.out.println("You did not enter a number, try again.");
                                }
                            }
                        }else {
                            System.out.println("Ingredient ID does not exist");
                        }
                    }
                }else if (option == 9) { //Add recipe
                    Recipe.initializeRecipeName(user);
                } else if (option == 10) { //Get recipe
                    Recipe.getRecipe();
                }  else if (option == 11) { //View shopping list
                    viewShoppingList(ingredients, user.getUsername());
                } else if (option == 12) { //View History
                    PersonalHistory.displayHistory(user);
                } else if (option == 13) { //Logout/Exit
                    PersonalHistory.recordHistory(user);
                    run = false;
                } else {
                    System.out.println("Invalid option entered, enter a number 1-13 to view data.");
                }

            }
            catch (InputMismatchException ime) {
                System.out.println("Invalid option entered, enter a number 1-13 to view data.");
                scanner.nextLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}