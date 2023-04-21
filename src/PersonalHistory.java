package src;

import java.util.*;
import src.objs.User;
import src.TrackingMeal;
import src.TrackingWorkout;
public class PersonalHistory {
    
    public int weight;
    public String name;
    public static int caloriesConsumed = 0;
    public static int caloriesLost = 0;
    static ArrayList<String> workouts = new ArrayList<String>();
    static ArrayList<String> meals = new ArrayList<String>();
    /** The user may browse their personal history including:
         Weight
         Calories consumed vs. target for that day
         Meals
         Workouts */
     public PersonalHistory(){
 
     }
     /** Get info (duration of workout, intensity, and calories burned) from TrackingWorkout 
      * and save it to an list for workout history. 
      This method is called in TrackingWorkout in order to pass this info. */
     public static void addWorkout(int minutes, String intensity, int caloriesBurned){
         
         String test = "You burned " + caloriesBurned + " in this " + intensity + " workout that lasted " + minutes + " minutes";
         workouts.add("You burned " + caloriesBurned + " in this " + intensity + " workout that lasted " + minutes + " minutes");
        //Total calories lost from all workouts stored
         caloriesLost += caloriesBurned;
         System.out.println(test);
     }
     /** Get info (meal name and calories in it) from TrackingMeal 
      * and save it to an list for meal history. 
      This method is called in TrackingMeal in order to pass this info. */
     public static void addMeal(String meal, int calories){
        String test = "You ate " + meal + " which had " + calories ;
        //add string with meal info.
         meals.add("You ate " + meal + " which had " + calories );
         //Total calories gained from all meals stored
         caloriesConsumed += calories;
         System.out.println(test);
     }
     public PersonalHistory(User anon){
    //Empty constructor for now. Might be useful for future use when User things are fully functional
     }
 
     public static void test(){
         User nobody = new User("dummy", "OOgswgvRGIaeBR=", "tommy",
          "danger", "300", "5ft 8","160", "11/17/2002");
          
          TrackingWorkout tracker = new TrackingWorkout(1000, 5, 7, 10);
          tracker.recordWorkout(30, "medium");
          tracker.recordWorkout(10, "high");
         // TrackingMeal mealTracker = new TrackingMeal(2000);

          System.out.println("Total calories burned: " + caloriesLost);
         // System.out.println("Total calories burned: " + tracker.getCaloriesBurned());
          System.out.println("Remaining calories to meet daily target: " + tracker.getRemainingCalories());
 
        

        /**
         * code for writing all saved info into .scsv file
                try {
                    FileWriter fw = new FileWriter("src/databases/histories.csv", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(username + "," + dailyTarget + "," + meals +"," + workouts + "\n");
                    bw.close();
                    //System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("Error [UserUtils.createUser] ! An error occurred: ");
                    e.printStackTrace();
                }
        */
 
 
         System.out.println("Weight: " + nobody.getWeight());
 
         System.out.println("Daily target: " + nobody.getDailyTarget());
 
 
     }
 
     public static void main(String[] args) {
         System.out.println("In personal history...");
         test();
     }
}
