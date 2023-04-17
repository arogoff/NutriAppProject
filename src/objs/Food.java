package src.objs;

abstract class Food {
    public double calories;
    public double fat;
    public double protein;
    public double fiber;
    public double carbs;

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getFat() {
        return fat;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getProtein() {
        return protein;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public double getFiber() {
        return fiber;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getCarbs() {
        return carbs;
    }

    public Food(String name, double calories, double fat, double protein, double fiber, double carbs) {
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.fiber = fiber;
        this.carbs = carbs;
    }

    public abstract void createFood();

    public String getNutritionalInfo() {
        return calories + " " + fat + " " + protein + " " + fiber + " " + carbs;
    }

}
