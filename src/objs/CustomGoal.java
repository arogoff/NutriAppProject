package src.objs;

public class CustomGoal extends Goal{
    public CustomGoal(String type) {
        super(type);
    }

    @Override
    public void createGoal(String height, int weight, int age, String gender) {
        int ft = Integer.parseInt(height.split("ft ")[0]);
        int inches = Integer.parseInt(height.split("ft ")[1]);
        int inchesTotal = (ft*12) + inches;
        double heightCm = inchesTotal*2.54;
        // here is where the calculation is
        if(gender.equalsIgnoreCase("m")){
            calorieLimit = (int) ((66.5 + (13.75 * (weight * 0.4535924)) + (5.003 * heightCm) - (6.775*age) - 500) * 1.2);
        } else if (gender.equalsIgnoreCase("f")) {
            calorieLimit = (int) ((655.1 + (9.563 * (weight * 0.4535924)) + (1.850 * heightCm) - (4.676*age) - 500) * 1.2);
        }
    }
}
