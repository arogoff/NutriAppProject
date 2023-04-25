package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import src.objs.User;
import src.TrackingMeal;
import src.TrackingWorkout;
public class PersonalHistory {
    
    public int weight;
    public String name;
    public static int caloriesConsumed = 0;
    public static int caloriesLost = 0;
    public static int totalCalories = 0;
    static ArrayList<String> workouts = new ArrayList<String>();
    static ArrayList<String> meals = new ArrayList<String>();
    public static String bigString = " ";
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
         
         String test = "You burned " + caloriesBurned + " in a " + intensity + " workout that lasted " + minutes + " minutes";
         workouts.add("You burned " + caloriesBurned + " in a " + intensity + " workout that lasted " + minutes + " minutes");
        //Total calories lost from all workouts stored
         caloriesLost += caloriesBurned;
         System.out.println(test);
     }

     //return a list of meals in the user's history
     public static List<String> mealsExist(User anon) throws IOException{

       
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader("src/databases/histories.csv"));
            inputFile.readLine(); // get rid of first line, just headers
            String line;

            while ((line = inputFile.readLine()) != null) {
            String[] person = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            
            }

            //if username isnt found in the array, then the user doesnt have meals
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        return null;
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
     
     }
     public PersonalHistory(User anon){
    //Will be useful for future use when User things are fully functional
        /** 
        System.out.println("You've burned " + caloriesLost + " calories.");
        System.out.println("You've consumed " + caloriesConsumed + " calories.");
         // System.out.println("Total calories burned: " + tracker.getCaloriesBurned());
        System.out.println("Remaining calories to meet daily target: " + (Integer.parseInt(anon.getDailyTarget()) - caloriesLost));
        */
     }
 
     public void recordHistory(User anon){
        //add time stamp
       
        bigString.concat("Weight: " + anon.getWeight() + "\n");
        bigString.concat("Daily target: " + anon.getDailyTarget() + "\n");
        bigString.concat("You've consumed " + caloriesConsumed + " calories.\n");

        for (String thing : meals) {
            bigString.concat(thing + "\n");
        }

        for (String exercise : workouts) {
            bigString.concat(exercise + "\n");
        }
        try {
            FileWriter fw = new FileWriter("src/databases/histories.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n" + anon.getUsername() + "," + anon.getDailyTarget() + "," + bigString);
            bw.close();
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error [UserUtils.createUser] ! An error occurred: ");
            e.printStackTrace();
        }
     }
     
 
     public static void main(String[] args) {
       
     }
}
