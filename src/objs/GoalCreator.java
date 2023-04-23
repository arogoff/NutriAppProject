package src.objs;

import src.utils.UserUtils;

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

            switch(ans){
                case "1":
                    type="maintain";
                    answer = false;
                    break;
                case "2":
                    type="gain";
                    answer = false;
                    break;
                case "3":
                    type="lose";
                    answer = false;
                    break;
                case "4":
                    type="custom";
                    answer = false;
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Please enter a number between 1 and 5!");
                    break;
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
        user.setGoalWeight(String.valueOf(goalWeight));
        user.setDailyTarget(String.valueOf(userGoal.getCalorieLimit()));
        user.setGoalType(type);
        UserUtils.updateUser(user);
    }

    public abstract Goal createGoalType(String type);

    public void getGoalInfo(){
        if(userGoal == null){
            System.out.println("You do not have a goal set!");
        }else{
            System.out.println(userGoal.getGoalInfo());
        }
    }

    public abstract void setUserGoal(String type, int calorieLimit, int goalWeight);

    public void checkWeight(User user){
        if(Integer.parseInt(user.getWeight()) == userGoal.goalWeight){
            System.out.println("You have reached your goal weight! Changing your goal to 'maintain'.");
            userGoal = createGoalType("maintain");
            userGoal.createGoal(user.getHeight(), Integer.parseInt(user.getWeight()), user.getAge(), user.getGender());
            userGoal.setGoalWeight(Integer.parseInt(user.getGoalWeight()));
            user.setDailyTarget(String.valueOf(userGoal.getCalorieLimit()));
            user.setGoalType("maintain");
            UserUtils.updateUser(user);
        }else if(Integer.parseInt(user.getWeight()) >= userGoal.goalWeight+5){
            System.out.println("You are over 5lbs above your goal weight! Your goal has been set to 'lose'.");
            userGoal = createGoalType("lose");
            userGoal.createGoal(user.getHeight(), Integer.parseInt(user.getWeight()), user.getAge(), user.getGender());
            userGoal.setGoalWeight(Integer.parseInt(user.getGoalWeight()));
            user.setDailyTarget(String.valueOf(userGoal.getCalorieLimit()));
            user.setGoalType("lose");
            UserUtils.updateUser(user);
        }else if(Integer.parseInt(user.getWeight()) <= userGoal.goalWeight-5){
            System.out.println("You are over 5lbs below your goal weight! Your goal has been set to 'gain'.");
            userGoal = createGoalType("gain");
            userGoal.createGoal(user.getHeight(), Integer.parseInt(user.getWeight()), user.getAge(), user.getGender());
            userGoal.setGoalWeight(Integer.parseInt(user.getGoalWeight()));
            user.setDailyTarget(String.valueOf(userGoal.getCalorieLimit()));
            user.setGoalType("gain");
            UserUtils.updateUser(user);
        }
    }

}
