package src.objs;

public interface Goal{

    void setType(String type);

    String getType();

    // Calculated using this formula http://www-users.med.cornell.edu/~spon/picu/calc/beecalc.htm
    void createGoal(String height, int weight, int age, String gender);

    String getGoalInfo();

    int getCalorieLimit();

    void setGoalWeight(int goalWeight);

    void setWorkoutTime(double workoutTime);

    double getWorkoutTime();

    int getGoalWeight();

    void register(User user);

    void deregister(User user);

    void notifyObservers(String event);
}
