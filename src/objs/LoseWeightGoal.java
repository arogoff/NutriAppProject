package src.objs;

import java.util.ArrayList;

public class LoseWeightGoal implements Goal{
    public String type;

    public int calorieLimit;

    public int goalWeight;
    public ArrayList<User> observers = new ArrayList<>();

    public LoseWeightGoal(String type) {
        this.type = type;
    }

    public LoseWeightGoal(String type, int calorieLimit, int goalWeight){
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

    public void createGoal(String height, int weight, int age, String gender) {
        String h = height.replace("\"", "");
        int ft = Integer.parseInt(h.split("'")[0]);
        int inches = Integer.parseInt(h.split("'")[1]);
        int inchesTotal = (ft*12) + inches;
        double heightCm = inchesTotal*2.54;
        // here is where the calculation is
        if(gender.equalsIgnoreCase("m")){
            calorieLimit = (int) ((66.5 + (13.75 * (weight * 0.4535924)) + (5.003 * heightCm) - (6.775*age) - 500) * 1.2);
        } else if (gender.equalsIgnoreCase("f")) {
            calorieLimit = (int) ((655.1 + (9.563 * (weight * 0.4535924)) + (1.850 * heightCm) - (4.676*age) - 500) * 1.2);
        }
    }


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
        System.out.println(event);
        for(User observer : observers){
            observer.update(event);
        }
    }
}
