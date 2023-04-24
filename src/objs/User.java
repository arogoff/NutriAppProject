package src.objs;

import src.utils.UserUtils;

public class User implements UserObserver{
    public String username;
    public String passwordHash;
    public String firstName;
    public String lastName;
    public String dailyTarget;
    public String height;
    public String weight;

    public String gender;

    public String goalWeight;

    public String goalType;

    public User(){

    }
    public User(String username, String passwordHash, String firstName, String lastName, String dailyTarget, String height, String weight, String goalWeight, String birthDate, String gender){
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dailyTarget = dailyTarget;
        this.height = height;
        this.weight = weight;
        this.goalWeight = goalWeight;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public String getGender() {
        return gender;
    }

    public int getAge(){
        return 0;
    }

    public String getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(String goalWeight) {
        this.goalWeight = goalWeight;
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

    public void update(String event) {
        if(event.split("\\|").length == 2){
            setDailyTarget(event.split("\\|")[0]);
            setGoalType(event.split("\\|")[1]);

            if(getGoalType().equals("gain")){
                System.out.println("You are over 5lbs below your goal weight of " + getGoalWeight() +"lbs! Your goal has been set to 'gain'.");
            }else if(getGoalType().equals("lose")){
                System.out.println("You are over 5lbs above your goal weight of " + getGoalWeight() +"lbs! Your goal has been set to 'gain'.");
            }else{
                System.out.println("You have reached your goal weight of " + getGoalWeight() +"lbs! Changing your goal to 'maintain'.");
            }
        }else{
            setDailyTarget(event.split("\\|")[0]);
            setGoalType(event.split("\\|")[1]);
            setGoalWeight(event.split("\\|")[2]);
            System.out.println("Your goal has been set to " + getGoalType() + ". Your goal weight is " + getGoalWeight() + "lbs with a daily target of " + getDailyTarget() + " calories.");
        }

        UserUtils.updateUser(this);
    }
}

