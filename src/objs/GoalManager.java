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
}
