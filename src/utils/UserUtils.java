package src.utils;

import src.objs.User;

import java.io.*;
import java.util.ArrayList;

public class UserUtils {

    // userArrayList - Holds all user objects from users.csv
    public static ArrayList<User> userArrayList = new ArrayList<>();

    /*
     * Method loadUsers()
     * Read in and create a user profile for everyone listed in users.csv. Attach each user object to the userArrayList above.
     * no return
     */
    public static ArrayList<User> loadUsers(){
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader("src/databases/users.csv"));

            inputFile.readLine(); // get rid of first line, just headers
            String answer;

            while ((answer = inputFile.readLine()) != null) {
                System.out.println(answer);

                String[] user = answer.split(",");
                userArrayList.add(new User(user[0], user[1], user[2], user[3], user[4], user[5], user[6], user[7]));


            }

            return userArrayList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
     * Method getUser()
     * Parameter: String userName
     * Search through the userArrayList to get the user object associated with the userName.
     * Returns User object
     */
    public static User getUser(String userName){
        for(User u : userArrayList){
            if(u.getUsername().equals(userName)){
                return u;
            }
        }

        return null;
    }

    /*
     * Method createUser()
     * Parameter: String username, String passwordHash, String firstName, String lastName, String dailyTarget, String height, String weight, String birthDate
     * Call doesUserExist() to ensure no duplicate usernames (final check). Create a new User object with the parameters and add them to the users.csv file.
     * Returns User object
     */
    public static User createUser(String username, String passwordHash, String firstName, String lastName, String dailyTarget, String height, String weight, String birthDate){
        if(doesUserExist(username)){
            System.out.println("Error [UserUtils.createUser] ! User already exists!");
        }else if(username != null && passwordHash != null){
            User newUser = new User(username, passwordHash, firstName, lastName, dailyTarget, height, weight, birthDate);
            try {
                FileWriter fw = new FileWriter("src/databases/users.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(username + "," + passwordHash + "," + firstName+ "," + lastName + "," + dailyTarget + "," + height + "," + weight + "," +birthDate + "\n");
                bw.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("Error [UserUtils.createUser] ! An error occurred: ");
                e.printStackTrace();
            }
            //write user to users.csv
            return newUser;
        }else if(username.equals(null) || passwordHash.equals(null)){
            System.out.println("Error [UserUtils.createUser] ! Username is null and/or passwordHash is null!");
        }
        return null;
    }

    /*
     * Method doesUserExist()
     * Parameter: String username
     * Check to see if user exists in the userArrayList. If so, return true, otherwise return false
     * Returns boolean value
     */
    public static boolean doesUserExist(String userName){
        for(User u : userArrayList){
            if(u.getUsername().equals(userName)){
                return true;
            }
        }

        return false;
    }
}
