package src;

import src.objs.User;
import src.utils.UserUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class ProxyLogin implements LogIn{
    @Override
    public User authenticate(String usr) {
        RealLogIn login = new RealLogIn();
        Scanner reader = new Scanner(System.in);

        // Prompt the user for their username. Check to ensure that a user with that username exists.
        System.out.println("Enter your username: ");
        String username = reader.nextLine();

        if(!UserUtils.doesUserExist(username)){
            System.out.println("User does not exist. Try again.");
            return null;
        }

        int attempts = 1;

        // Prompt the user for their password. Verify password is what is associated with the accoun they are trying to login with. If its correct call RealLogIn's authenticate method.
        Boolean passwordContinue = true;
        while(passwordContinue){
            System.out.println("Enter your password: ");
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(reader.nextLine().getBytes(StandardCharsets.UTF_8));
                String passwordHash = Base64.getEncoder().encodeToString(hash);

                User potentialUser = UserUtils.getUser(username);

                if(passwordHash.equals(potentialUser.getPasswordHash())){
                    passwordContinue = false;
                    return login.authenticate(username);
                }else{
                    System.out.println("Incorrect password. Attempt #" + attempts);
                    if(attempts >= 3){
                        System.out.println("Three wrong password attempts.");
                        passwordContinue = false;
                        return null;
                    }
                    attempts++;
                }
            }catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
        }

        return null;

    }
}
