package src.tests;
import src.objs.Meal;
import src.objs.Recipe;
import src.TrackingMeal;
import java.util.*;

public class MealRecipeTest {
    ArrayList<Recipe> th = new ArrayList<>();
    /**
     * 18371 LEAVENING AGENTS,BAKING PDR,LOW-SODIUM 97
      1123 EGG,WHL,RAW,FRSH 143
      2050 VANILLA EXTRACT 288
      16055 CAROB FLOUR 222
      1077 MILK,WHL,3.25% MILKFAT,W/ ADDED VITAMIN D 61
      1002 BUTTER,WITH SALT 718
      19335 SUGARS,GRANULATED 387
     */
    public static void main(String[] args) {
       Recipe bkb = new Recipe("cake", null, null, null, null, null);
       bkb.createRecipe("cake");

        //return name of <recipe, <ingredient, amount>>
      HashMap<String, HashMap<String, Double>> bjrkubk = new HashMap<>();
      

      TrackingMeal barbados = new TrackingMeal(2000) ;
      List<String> things = new ArrayList<String>();
        things.add("cake");
        things.add("brownie");
      barbados.addMeal("Dinner", things);
      //  barbados.addRecipe("din", bkb);


    }
}