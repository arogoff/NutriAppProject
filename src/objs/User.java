package src.objs;

public class User {
    public String username;
    public String passwordHash;
    public String firstName;
    public String lastName;
    public String dailyTarget;
    public String height;
    public String weight;

    public User(){

    }
    public User(String username, String passwordHash, String firstName, String lastName, String dailyTarget, String height, String weight, String birthDate){
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dailyTarget = dailyTarget;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
    }

    public void setDailyTarget(String dailyTarget) {
        this.dailyTarget = dailyTarget;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDailyTarget() {
        return dailyTarget;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String birthDate;

}

    abstract class Food {
        int calories;
        int fat;
        int protein;
        int fiber;
        int carbs;

        public void setCalories(int calories) { this.calories = calories; }
        public int getCalories() { return calories; }
        public void setFat(int fat) { this.fat = fat; }
        public int getFat() { return fat; }
        public void setProtein(int protein) { this.protein = protein; }
        public int getProtein() { return protein; }
        public void setFiber(int fiber) { this.fiber = fiber; }
        public int getFiber() { return fiber; }
        public void setCarbs(int carbs) { this.carbs = carbs; }
        public int getCarbs() { return carbs; }

        public Food(String name, int calories, int fat, int protein, int fiber, int carbs) {
            this.calories = calories;
            this.fat = fat;
            this.protein = protein;
            this.fiber = fiber;
            this.carbs = carbs;
        }

        public abstract void createFood();

        public String getNutritionalInfo() {
            return calories + "" + fat + "" + protein + "" + fiber + "" + carbs;
        }

    }

class Recipe {
    int calories;
    int fat;
    int protein;
    int fiber;
    int carbs;

    public void setCalories(int calories) { this.calories = calories; }
    public int getCalories() { return calories; }
    public void setFat(int fat) { this.fat = fat; }
    public int getFat() { return fat; }
    public void setProtein(int protein) { this.protein = protein; }
    public int getProtein() { return protein; }
    public void setFiber(int fiber) { this.fiber = fiber; }
    public int getFiber() { return fiber; }
    public void setCarbs(int carbs) { this.carbs = carbs; }
    public int getCarbs() { return carbs; }

    public Recipe(String name, int calories, int fat, int protein, int fiber, int carbs) {
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.fiber = fiber;
        this.carbs = carbs;
    }

    public void createRecipe() {

    }

    public String getNutritionalInfo() {
        return calories + "" + fat + "" + protein + "" + fiber + "" + carbs;
    }

}

class Meal {
    int calories;
    int fat;
    int protein;
    int fiber;
    int carbs;

    public void setCalories(int calories) { this.calories = calories; }
    public int getCalories() { return calories; }
    public void setFat(int fat) { this.fat = fat; }
    public int getFat() { return fat; }
    public void setProtein(int protein) { this.protein = protein; }
    public int getProtein() { return protein; }
    public void setFiber(int fiber) { this.fiber = fiber; }
    public int getFiber() { return fiber; }
    public void setCarbs(int carbs) { this.carbs = carbs; }
    public int getCarbs() { return carbs; }

    public Meal(String name, int calories, int fat, int protein, int fiber, int carbs) {
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.fiber = fiber;
        this.carbs = carbs;
    }

    public void createMeal() {

    }

    public String getNutritionalInfo() {
        return calories + "" + fat + "" + protein + "" + fiber + "" + carbs;
    }

}

class Workout {
    int minutes;
    int intensity;
    String time;
    String date;
    int caloriesToAdd;

    public void setMinutes(int minutes) { this.minutes = minutes; }
    public int getMinutes() { return minutes; }
    public void setIntensity(int intensity) { this.intensity = intensity; }
    public int getIntensity() { return intensity; }
    public void setTime(String time) { this.time = time; }
    public String getTime() { return time; }
    public void setDate(String date) { this.date = date; }
    public String getDate() { return date; }
    public void setCaloriesToAdd(int caloriesToAdd) { this.caloriesToAdd = caloriesToAdd; }
    public int getCaloriesToAdd() { return caloriesToAdd; }

    public Workout(int minutes, int intensity, String time, String date, int caloriesToAdd) {
        this.minutes = minutes;
        this.intensity = intensity;
        this.time = time;
        this.date = date;
        this.caloriesToAdd = caloriesToAdd;
    }

    public void createWorkout() {

    }

    public String getWorkoutInfo() {
        return minutes + "" + intensity + "" + time + "" + date + "" + caloriesToAdd;
    }

}

class Goal {
    String type;

    public void setType(String type) { this.type = type; }
    public String getType() { return type; }

    public Goal(String type) {
        this.type = type;
    }

    public void createGoal() {

    }

    public String getGoalInfo() {
        return type;
    }

}