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
    public void setUserGoal(String type, int calorieLimit, int goalWeight, double workoutTime) {
        switch (type.toLowerCase()) {
            case "maintain" -> userGoal = new MaintainWeightGoal(type, calorieLimit, goalWeight);
            case "lose" -> userGoal = new LoseWeightGoal(type, calorieLimit, goalWeight);
            case "gain" -> userGoal = new GainWeightGoal(type, calorieLimit, goalWeight);
            case "custom" -> userGoal = new CustomGoal(type, calorieLimit, goalWeight, workoutTime);
            default -> {
            }
        }
    }

    public void register(User user){
        userGoal.register(user);
    }

    public void deregister(User user){
        userGoal.deregister(user);
    }

    public void notifyObserver(String event){
        userGoal.notifyObservers(event);
    }

    public void checkWeight(User user){
        int goalWeight = userGoal.getGoalWeight();
        if(Integer.parseInt(user.getWeight()) == userGoal.getGoalWeight()){
            //System.out.println("You have reached your goal weight of " + userGoal.getGoalWeight() +"lbs! Changing your goal to 'maintain'.");
            userGoal = createGoalType("maintain");
            userGoal.createGoal(user.getHeight(), Integer.parseInt(user.getWeight()), user.getAge(), user.getGender());
            userGoal.setGoalWeight(goalWeight);

            userGoal.register(user);

            userGoal.notifyObservers(userGoal.getCalorieLimit() + "|" + "maintain");
        }else if(Integer.parseInt(user.getWeight()) >= userGoal.getGoalWeight()+5){
            //System.out.println("You are over 5lbs above your goal weight of " + userGoal.getGoalWeight() +"lbs! Your goal has been set to 'lose'.");
            userGoal = createGoalType("lose");
            userGoal.createGoal(user.getHeight(), Integer.parseInt(user.getWeight()), user.getAge(), user.getGender());
            userGoal.setGoalWeight(goalWeight);

            userGoal.register(user);

            userGoal.notifyObservers(userGoal.getCalorieLimit() + "|" + "lose");
        }else if(Integer.parseInt(user.getWeight()) <= userGoal.getGoalWeight()-5){
            //System.out.println("You are over 5lbs below your goal weight of " + userGoal.getGoalWeight() +"lbs! Your goal has been set to 'gain'.");
            userGoal = createGoalType("gain");
            userGoal.createGoal(user.getHeight(), Integer.parseInt(user.getWeight()), user.getAge(), user.getGender());
            userGoal.setGoalWeight(goalWeight);

            userGoal.register(user);

            userGoal.notifyObservers(userGoal.getCalorieLimit() + "|" + "gain");
        }
    }
}
