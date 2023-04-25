package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import src.objs.User;
import src.TrackingMeal;
import src.TrackingWorkout;
public class PersonalHistory {
    
    public int historyWeight;
    public String name;
    public static int caloriesConsumed = 0;
    public static int caloriesLost = 0;
    public static int totalCalories = 0;
    static ArrayList<String> workouts = new ArrayList<String>();
    static ArrayList<String> meals = new ArrayList<String>();
    public static String bigString = " ";
    public static String userName = "";
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
     public static void addWorkout(User anon, int minutes, String intensity, int caloriesBurned){
         userName = anon.username ;
         String test = "You burned " + caloriesBurned + " in a " + intensity + " workout that lasted " + minutes + " minutes";
         workouts.add("You burned " + caloriesBurned + " in a " + intensity + " workout that lasted " + minutes + " minutes");
        //Total calories lost from all workouts stored
         caloriesLost += caloriesBurned;
         System.out.println(test);
     }

     //return a list of meals in the user's history
     public static List<String> mealsExist(User anon) throws IOException{

       
        File f1=new File("src/databases/histories.csv"); 
        String[] words=null;  
        FileReader fr;
        try {
            fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr); 
            String s;     
          
            while((s=br.readLine())!=null)   //Reading Content from the file
            {
                if(s.contains(anon.username)){
                    String[] person = s.split(",");
                    if(person[4].length() > 0){
                        String[] recordedMeals = person[4].split(",");
                        List<String> mealsList = Arrays.asList(recordedMeals);
                        return mealsList;
                    } else {
                        return null;
                    }
                } else{
                    return null;
                }
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
       // userName = anon.username ;
        String test = "You ate " + meal + " which had " + calories ;

        //add string with meal info.
         meals.add("You ate " + meal + " which had " + calories );

         //Total calories gained from all meals stored
         caloriesConsumed += calories;
     
     }
     public PersonalHistory(User anon){
   
        /** 
        System.out.println("You've burned " + caloriesLost + " calories.");
        System.out.println("You've consumed " + caloriesConsumed + " calories.");
         // System.out.println("Total calories burned: " + tracker.getCaloriesBurned());
        System.out.println("Remaining calories to meet daily target: " + (Integer.parseInt(anon.getDailyTarget()) - caloriesLost));
        */
     }
 
     public static void displayHistory(User anon) throws IOException{
        String bigString = "";

        File f1=new File("src/databases/histories.csv"); //Creation of File Descriptor for input file
        String[] words=null;  //Intialize the word Array
        FileReader fr;
        try {
            fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
            String s;     
          
            while((s=br.readLine())!=null)   //Reading Content from the file
            {
                if(s.contains(anon.username)){
                    String[] person = s.split(",");
                    decipherHistory(person, anon);
                   
                }
            }
       
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  //Creation of File Reader object
       

        System.out.println();
     }

     public static void decipherHistory(String[] person, User anon){
        System.out.println("Weight: " + anon.weight);
        System.out.println("Calories consumed today: " + person[3]);
        System.out.println("Workouts: " + person[5]);
        System.out.println("Meals: "+ person[4]);
        /** 
        System.out.println("Meals: ");
        
        for (String string : meals) {
            System.out.println(string);
        }
        System.out.println("Workouts: ");
        for (String string : workouts) {
            System.out.println(string);
        }
        */
     }
     public static void recordHistory(User anon){
        //add time stamp
       
        bigString.concat("Weight: " + anon.getWeight() + "\n");
        bigString.concat("Daily target: " + anon.getDailyTarget() + "\n");
        bigString.concat("You've consumed " + caloriesConsumed + " calories.\n");
       String mealString =  "[";
        for (String thing : meals) {
            mealString+=(thing + " | ");
        }
        mealString += "]";
        String workString= "<";
        for (String exercise : workouts) {
            workString += exercise + " | ";
            System.out.println("going into databsse: " + exercise);
        }
        workString+= ">";
        try {
            //userName,dailyTarget,caloriesConsumed,weight,meals,workouts
            FileWriter fw = new FileWriter("src//databases//histories.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n" + anon.getUsername() + "," + anon.getDailyTarget() + "," + caloriesConsumed +
             "," + anon.weight + "," + mealString + "," + workString);
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
