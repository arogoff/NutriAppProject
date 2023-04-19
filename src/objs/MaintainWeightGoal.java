package src.objs;

public class MaintainWeightGoal extends Goal{
    public MaintainWeightGoal(String type) {
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
