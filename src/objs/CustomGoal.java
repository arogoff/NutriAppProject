package src.objs;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomGoal implements Goal{
    public String type;

    public int calorieLimit;

    public int goalWeight;

    public ArrayList<User> observers = new ArrayList<>();

    public CustomGoal(String type) {
        this.type = type;
    }

    public CustomGoal(String type, int calorieLimit, int goalWeight){
        this.type = type;
        this.calorieLimit = calorieLimit;
        this.goalWeight = goalWeight;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void createGoal(String height, int weight, int age, String gender) {
        double workoutTime = 0;
        Scanner reader = new Scanner(System.in);

        boolean answer = true;
        int added = 0;
        while(answer){
            System.out.println("What kind of goal would you like?");
            System.out.println("""
                        1 - Maintain Weight
                        2 - Gain Weight
                        3 - Lose Weight""");
            String ans = reader.nextLine();

            switch (ans) {
                case "1" -> {
                    added = 0;
                    answer = false;
                }
                case "2" -> {
                    added = 500;
                    answer = false;
                }
                case "3" -> {
                    added = -500;
                    answer = false;
                }
                default -> System.out.println("Please enter a number between 1 and 3!");
            }
        }

        answer = true;
        if (answer) {
            System.out.println("How physically active would you like to be? 1 - Low, 2 - Medium, 3 - High");
            String ans = reader.nextLine();

            if(!ans.equals("1") | !ans.equals("2") | !ans.equals("3")){
                System.out.println("Not a valid input. Try again.");
            }else{
                switch (ans) {
                    case "1" -> {
                        workoutTime = 1.5;
                        answer = false;
                    }
                    case "2" -> {
                        workoutTime = 1.75;
                        answer = false;
                    }
                    case "3" -> {
                        workoutTime = 2;
                        answer = false;
                    }
                    default -> {
                        workoutTime = 1.2;
                        answer = false;
                    }
                }
            }
        }

        String h = height.replace("\"", "");
        int ft = Integer.parseInt(h.split("'")[0]);
        int inches = Integer.parseInt(h.split("'")[1]);
        int inchesTotal = (ft*12) + inches;
        double heightCm = inchesTotal*2.54;
        // here is where the calculation is
        if(gender.equalsIgnoreCase("m")){
            calorieLimit = (int) ((66.5 + (13.75 * (weight * 0.4535924)) + (5.003 * heightCm) - (6.775*age) + added) * workoutTime);
        } else if (gender.equalsIgnoreCase("f")) {
            calorieLimit = (int) ((655.1 + (9.563 * (weight * 0.4535924)) + (1.850 * heightCm) - (4.676*age) + added) * workoutTime);
        }
    }

    @Override
    public String getGoalInfo() {
        return "Goal type: " + getType() + " - Suggested Calorie Intake: " + getCalorieLimit();
    }

    @Override
    public int getCalorieLimit() {
        return calorieLimit;
    }

    @Override
    public void setGoalWeight(int goalWeight) {
        this.goalWeight = goalWeight;
    }

    @Override
    public int getGoalWeight() {
        return goalWeight;
    }

    public void register(User user) {
        observers.add(user);
    }

    public void deregister(User user) {
        observers.remove(user);
    }

    public void notifyObservers(String event) {
        for(User observer : observers){
            observer.update(event);
        }
    }
}
