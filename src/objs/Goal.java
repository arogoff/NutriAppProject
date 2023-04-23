package src.objs;

public abstract class Goal {
    public String type;

    public int calorieLimit;

    public int goalWeight;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Goal(String type) {
        this.type = type;
    }

    public Goal(String type, int calorieLimit, int goalWeight){
        this.type = type;
        this.calorieLimit = calorieLimit;
        this.goalWeight = goalWeight;
    }

    // Calculated using this formula http://www-users.med.cornell.edu/~spon/picu/calc/beecalc.htm
    public abstract void createGoal(String height, int weight, int age, String gender);

    public String getGoalInfo() {
        return "Goal Type: " + getType() + ". Calorie Limit: " + getCalorieLimit();
    }

    public int getCalorieLimit() {
        return calorieLimit;
    }

    public void setGoalWeight(int goalWeight) {
        this.goalWeight = goalWeight;
    }

    public int getGoalWeight() {
        return goalWeight;
    }

    public void register(User user){

    }

    public void deregister(User user){

    }

    public void notifyObservers(){

    }
}
