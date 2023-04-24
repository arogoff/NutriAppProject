package src.utils;

import src.objs.Ingredient;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadIngredients {
    public static HashMap<String, Ingredient> readIn(){
        HashMap<String, Ingredient> ingredients = new HashMap<>();
        //^change to map
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader("src/databases/ingredients.csv"));

            inputFile.readLine(); // get rid of first line, just headers
            String line;

            while ((line = inputFile.readLine()) != null) {
                // split the line on a comma if there are no " before the ,
                // allows strings like "xyz,be",hi to be split into "xyz,be" and hi.
                //ingredient id = key, ingredient obj = value
                Ingredient x = new Ingredient(line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
                ingredients.put(x.ingNum(), x);
            }
            
            return ingredients;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
