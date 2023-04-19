package src;

import src.objs.User;
import src.utils.UserUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class ProxyCreateUser implements CreateUser {
    @Override
    public User authenticate(String username, String passwordHash, String firstName, String lastName, String dailyTarget, String height, String weight, String birthDate) {
        Scanner reader = new Scanner(System.in);
        RealCreateUser create = new RealCreateUser();

        // Prompt the user for the username they would like. Ensure that username isn't taken.

            System.out.print("Enter the username you would like to use: ");
            username = reader.nextLine();
            System.out.println(username);

            if(UserUtils.doesUserExist(username)){
                System.out.println("That username already exists! Please try again.");
                return null;
            }else{
                // Prompt the user for the password they want to use. Once they have it, encrypt it via SHA-256
                System.out.print("Enter the password you would like to use: ");
                try{
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    byte[] hash = digest.digest(reader.nextLine().getBytes(StandardCharsets.UTF_8));
                    passwordHash = Base64.getEncoder().encodeToString(hash);
                }catch(NoSuchAlgorithmException e){
                    e.printStackTrace();
                    passwordHash = null;
                }

                // Prompt user for First & last name
                System.out.print("Enter your first name: ");
                firstName = reader.nextLine();

                System.out.print("Enter your last name: ");
                lastName = reader.nextLine();

                // Prompt user for birthday, ensure it is in the proper format
                birthDate = "";
                boolean dateContinue = true;
                while(dateContinue){
                    System.out.print("Enter the your birthdate in the following format 'mm/dd/yyyy': ");
                    birthDate = reader.nextLine();

                    // Finish this

                    dateContinue = false;
                }

                // Prompt user for their height, ensure it is in the proper format
                height = "";
                boolean heightContinue = true;
                while(heightContinue){
                    System.out.print("Enter the your height in the following format: #'#\" ex: 5'08\": ");
                    height = reader.nextLine();

                    String pattern = "^[3-8]{1}\\'([0-9]{1}|0[0-9]{1}|1[0-1]{1})(\\\"|\\s*((1\\/4|1\\/2|3\\/4))\\\")$";
                    if(height.matches(pattern)){
                        heightContinue = false;
                    }else{
                        System.out.println("Invalid height. Try again!");
                        System.out.println("Would you like to try again? (y/n)");
                        String ans = reader.nextLine();
                        if(ans.equals("n") || ans.equals("N")){
                            heightContinue = false;
                            return null;
                        }
                    }
                }

                // Prompt user for their weight
                System.out.print("Enter the your weight: ");
                weight = reader.nextLine();

                // Call the RealCreateUser's authenticate object
                return create.authenticate(username, passwordHash, firstName, lastName, "notset", height, weight, birthDate );

            }

    }
}
