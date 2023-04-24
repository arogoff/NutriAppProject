package src.objs;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class GoalCreator {
    public Goal userGoal;
    public void createGoal(User user){
        // String type, String height, int weight, int age, String gender, int goalWeight
        Scanner reader = new Scanner(System.in);

        boolean answer = true;
        String type = "";
        while(answer){
            System.out.println("What kind of goal would you like?");
            System.out.println("""
                        1 - Maintain Weight
                        2 - Gain Weight
                        3 - Lose Weight
                        4 - Custom Goal
                        5 - Exit""");
            String ans = reader.nextLine();

            switch (ans) {
                case "1" -> {
                    type = "maintain";
                    answer = false;
                }
                case "2" -> {
                    type = "gain";
                    answer = false;
                }
                case "3" -> {
                    type = "lose";
                    answer = false;
                }
                case "4" -> {
                    type = "custom";
                    answer = false;
                }
                case "5" -> {
                    return;
                }
                default -> System.out.println("Please enter a number between 1 and 5!");
            }
        }

        answer = true;
        int goalWeight = 0;
        while(answer){
            System.out.println("What is your goal weight? Your current weight is: " + user.getWeight());

            try{
                goalWeight = reader.nextInt();

                if(type.equals("maintain") && goalWeight != Integer.parseInt(user.getWeight())){
                    System.out.println("You wanted to maintain your weight, yet your goal weight doesn't match your current weight!");
                }else if(type.equals("lose") && goalWeight >= Integer.parseInt(user.getWeight())){
                    System.out.println("You wanted to lose weight, yet your goal weight is greater than your current weight!");
                }else if(type.equals("gain") && goalWeight <= Integer.parseInt(user.getWeight())){
                    System.out.println("You wanted to gain weight, yet your goal weight is less than your current weight!");
                }
                else if(goalWeight >= 50 && goalWeight <= 300){
                    answer = false;
                    System.out.println("Please enter desired workout time in hours per day (Ex: 2.5");
                    user.setWorkoutTime(user.workoutTime);
                }else{
                    System.out.println("Please enter a number between 50 and 300.");
                }
            }catch(InputMismatchException ime){
                System.out.println("Not a number! Try again");
            }

            reader.nextLine();
        }

        userGoal = createGoalType(type);
        userGoal.createGoal(user.getHeight(), Integer.parseInt(user.getWeight()), user.getAge(), user.getGender());
        userGoal.setGoalWeight(goalWeight);
        userGoal.register(user);


        userGoal.notifyObservers(userGoal.getCalorieLimit() + "|" +  type + "|" + goalWeight);

    }

    public abstract Goal createGoalType(String type);

    public void getGoalInfo(){
        if(userGoal == null){
            System.out.println("You do not have a goal set!");
        }else{
            System.out.println(userGoal.getGoalInfo());
        }
    }

    public abstract void setUserGoal(String type, int calorieLimit, int goalWeight, double workoutTime);

    public abstract void checkWeight(User user);

}
