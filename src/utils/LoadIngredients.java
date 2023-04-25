package src.utils;

import src.objs.Ingredient;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoadIngredients {
    public static HashMap<String, Ingredient> readIn(String username){
        HashMap<String, Ingredient> ingredients = new HashMap<>();
        HashMap<String, Integer> ingredientStock = readInStock(username);

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
                x.setStock(ingredientStock.get(x.ingNum()));
                ingredients.put(x.ingNum(), x);
            }
            
            return ingredients;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap<String, Integer> readInStock(String username){
        HashMap<String, Integer> ingredientStock = new HashMap<>();
        //^change to map
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader("src/databases/" + username + "_stock.csv"));

            //inputFile.readLine(); // get rid of first line, just headers
            String line;

            while ((line = inputFile.readLine()) != null) {

                ingredientStock.put(line.split(",")[0], Integer.valueOf(line.split(",")[1]));
            }
            return ingredientStock;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateStock(Ingredient ingredient, String username){
        try{
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of("src/databases/stock.csv"), StandardCharsets.UTF_8));

            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).split(",")[0].equals(ingredient.ingNum())) {
                    fileContent.set(i, ingredient.ingNum() + "," + ingredient.getStock());
                    break;
                }
            }

            Files.write(Path.of("src/databases/" + username + "_stock.csv"), fileContent, StandardCharsets.UTF_8);
        }catch(IOException ioe){
            System.out.println("Error! [UserUtils.updateUser] ! IOException Occured!");
        }

    }

    public static  void copyFile(String username) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("src/databases/stock.csv");
            os = new FileOutputStream("src/databases/" + username + "_stock.csv");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch(FileNotFoundException fnfe) {
            System.out.println("Couldn't find stock.csv.");
        }
        catch(IOException e) {
            System.out.println("Error writing file.");
        }

    }
}
