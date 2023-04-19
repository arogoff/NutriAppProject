package src.objs;

abstract class Food {
    public String name;
    public String calories;
    public String fat;
    public String protein;
    public String fiber;
    public String carbs;

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCalories() {
        return calories;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getFat() {
        return fat;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getProtein() {
        return protein;
    }

    public void setFiber(String fiber) {
        this.fiber = fiber;
    }

    public String getFiber() {
        return fiber;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public String getCarbs() {
        return carbs;
    }

    public Food(String name, String calories, String fat, String protein, String fiber, String carbs) {
        this.name = name;
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
