package src.objs;

public abstract class GoalCreator {
    public void createGoal(String type, String height, int weight, int age, String gender, int goalWeight){
        Goal goal = createGoalType(type);
        goal.createGoal(height, weight, age, gender);
        goal.setGoalWeight(goalWeight);
        goal.getCalorieLimit();
    }

    public abstract Goal createGoalType(String type);
}
