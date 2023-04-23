package src.objs;

public class GoalManager extends GoalCreator{
    @Override
    public Goal createGoalType(String type) {
        return switch (type.toLowerCase()) {
            case "maintain" -> new MaintainWeightGoal(type);
            case "lose" -> new LoseWeightGoal(type);
            case "gain" -> new GainWeightGoal(type);
            case "custom" -> new CustomGoal(type);
            default -> null;
        };
    }

    @Override
    public void setUserGoal(String type, int calorieLimit, int goalWeight) {
        switch (type.toLowerCase()) {
            case "maintain" -> userGoal = new MaintainWeightGoal(type, calorieLimit, goalWeight);
            case "lose" -> userGoal = new LoseWeightGoal(type, calorieLimit, goalWeight);
            case "gain" -> userGoal = new GainWeightGoal(type, calorieLimit, goalWeight);
            case "custom" -> userGoal = new CustomGoal(type, calorieLimit, goalWeight);
            default -> {
            }
        }
    }
}
