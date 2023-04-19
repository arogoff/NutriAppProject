package src.objs;

public abstract class Goal {
    public String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Goal(String type) {
        this.type = type;
    }

    public abstract void createGoal();

    public abstract String getGoalInfo();

    public abstract int getCalorieLimit();

}
