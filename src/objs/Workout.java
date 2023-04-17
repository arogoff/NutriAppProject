package src.objs;

public class Workout {
    public int minutes;
    public int intensity;
    public String time;
    public String date;
    public int caloriesToAdd;

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setCaloriesToAdd(int caloriesToAdd) {
        this.caloriesToAdd = caloriesToAdd;
    }

    public int getCaloriesToAdd() {
        return caloriesToAdd;
    }

    public Workout(int minutes, int intensity, String time, String date, int caloriesToAdd) {
        this.minutes = minutes;
        this.intensity = intensity;
        this.time = time;
        this.date = date;
        this.caloriesToAdd = caloriesToAdd;
    }

    public String getWorkoutInfo() {
        return minutes + " " + intensity + " " + time + " " + date + " " + caloriesToAdd;
    }

}
