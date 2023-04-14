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
