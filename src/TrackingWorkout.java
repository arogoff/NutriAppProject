package src;
import java.time.LocalDateTime;
import java.util.Scanner;

import src.PersonalHistory;
import src.objs.User;
public class TrackingWorkout {
    private static int totalCalories;
    private int dailyTarget;
    private static int lowIntensity;
    private static int mediumIntensity;
    private static int highIntensity;
    private static LocalDateTime lastWorkoutTime;

    public TrackingWorkout(int dailyTarget, int lowIntensity, int mediumIntensity, int highIntensity) {
        this.dailyTarget = dailyTarget;
        this.lowIntensity = lowIntensity;
        this.mediumIntensity = mediumIntensity;
        this.highIntensity = highIntensity;
        this.totalCalories = 0;
        this.lastWorkoutTime = null;
    }
/*This program defines a TrackingWorkout  class that allows users to record workouts, track calories burned, and suggest
 workouts to burn off excess calories. The WorkoutTracker class has the following instance variables:

1. totalCalories: the total number of calories burned so far
2. dailyTarget: the user's daily target for calories burned
3. lowIntensity, mediumIntensity, and highIntensity: the number of calories burned per minute for each intensity level
4. lastWorkoutTime: the date and time of the last recorded workout*/

    /*
    * The WorkoutTracker class has the following methods:
    *   recordWorkout(int minutes, String intensity): records a workout of the given duration and intensity level,
    * updating the total calories burned and last workout time
    * getCaloriesBurned(): returns the total number of calories burned so far
    * getRemainingCalories(): returns the number of calories remaining to meet the daily target
    * suggestWorkout(): suggests a workout to burn off excess calories, based on the user's previously recorded workouts and intensity levels
    * getLastWorkoutTime(): returns the date and time of the last recorded workout
    * */
    public static void recordWorkout(User anon,int minutes, String intensity) {
        int caloriesBurned = 0;

        if (intensity.equalsIgnoreCase("low")) {
            caloriesBurned = minutes * 15;
        } else if (intensity.equalsIgnoreCase("medium")) {
            caloriesBurned = minutes * 20;
        } else if (intensity.equalsIgnoreCase("high")) {
            caloriesBurned = minutes * 25;
        }

        totalCalories += caloriesBurned;
        lastWorkoutTime = LocalDateTime.now();

        PersonalHistory.addWorkout(anon, minutes, intensity, caloriesBurned);
    }

    public static void workoutVisual(User anon){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the duration of your workout and the intensity in this format: intensity;minutes");
        String option = scanner.nextLine();
        
        String[] info = option.split(";");
        recordWorkout(anon, Integer.parseInt(info[1]), info[0]);
    }

    public int getCaloriesBurned() {
        return totalCalories;
    }

    public int getRemainingCalories() {
        return dailyTarget - totalCalories;
    }

    public String suggestWorkout() {
        int excessCalories = totalCalories - dailyTarget;

        if (excessCalories <= 0) {
            return "You have met your daily target!";
        }

        int suggestedMinutes = excessCalories / lowIntensity;
        String suggestedIntensity = "low";

        if (suggestedMinutes > 30) {
            suggestedMinutes = excessCalories / mediumIntensity;
            suggestedIntensity = "medium";
        }

        return "You have exceeded your daily target by " + excessCalories + " calories. To burn off the excess, try " +
                suggestedMinutes + " minutes of " + suggestedIntensity + "-intensity exercise.";
    }

    public LocalDateTime getLastWorkoutTime() {
        return lastWorkoutTime;
    }

    public static void main(String[] args) {
        TrackingWorkout tracker = new TrackingWorkout(1000, 5, 7, 10);

        // Record a workout of 30 minutes at medium intensity
       // tracker.recordWorkout(30, "medium");

        // Display the total calories burned and remaining calories
        System.out.println("Total calories burned: " + tracker.getCaloriesBurned());
        System.out.println("Remaining calories to meet daily target: " + tracker.getRemainingCalories());

        // Suggest a workout to burn off excess calories
        System.out.println(tracker.suggestWorkout());
    }

}
