package src.objs;

public class CustomGoal extends Goal{
    public CustomGoal(String type) {
        super(type);
    }

    @Override
    public void createGoal() {

    }

    @Override
    public String getGoalInfo() {
        return null;
    }

    @Override
    public int getCalorieLimit() {
        return 0;
    }
}
