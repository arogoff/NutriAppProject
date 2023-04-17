package src;

import src.objs.User;
import src.utils.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Main");
        LoadIngredients.readIn();
        System.out.println("Hello 'user', Please choose an option to view data!");

        Boolean run = true;
        Scanner scanner = new Scanner(System.in);

        while (run == true) {

            try {

                System.out.println("1 - Login\n2 - Create Account\n3 - Exit\n");

                int option = scanner.nextInt();

                if (option == 1) { //Login function
                    System.out.println("Login()");
                } else if (option == 2) { //Create account function
                    System.out.println("Create Account()");
                } else if (option == 3) { //Exit function
                    run = false;
                    System.out.println("Exit()");
                } else {
                    System.out.println("Invalid option entered, enter a number 1-3 to view data.");
                }

            }
            catch (InputMismatchException ime) {
                System.out.println("Invalid option entered, enter a number 1-3 to view data.");
                scanner.nextLine();
            }
        }

    }
}
