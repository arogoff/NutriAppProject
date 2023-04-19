import src.objs.*;
import src.utils.*;
import java.util.*;
import java.io.*;
import src.TrackingWorkout;

public class PersonalHistory {
   public int weight;
   public String name;

   /** The user may browse their personal history including:
        Weight
        Calories consumed vs. target for that day
        Meals
        Workouts */
    public PersonalHistory(){

    }
    public void addWorkout(){

    }

    public PersonalHistory(User anon){
        ArrayList<String> info = new ArrayList<String>();

        info.add(anon.getWeight());
        info.add(anon.getDailyTarget());
    }

    public static void test(){
        User nobody = new User("dummy", "OOgswgvRGIaeBR=", "tommy",
         "danger", "300", "5ft 8","160", "11/17/2002");
         
     //   System.out.println("Weight: " + nobody.getWeight());


       // System.out.println("Daily target: " + nobody.getDailyTarget());
    }

    public static void main(String[] args) {
        System.out.println("In personal history...");
        test();
    }
}
