package src;

import src.objs.User;
import src.utils.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main");
        UserUtils.loadUsers();
        System.out.println("Hello 'user', Please choose an option to view data!");

        boolean run = true;
        Scanner scanner = new Scanner(System.in);

        User currentUser = null;

        while (run) {

            try {

                System.out.println("1 - Login\n2 - Create Account\n3 - Exit\n");

                int option = scanner.nextInt();

                if (option == 1) { //Login function
                    ProxyLogin login = new ProxyLogin();

                    currentUser = login.authenticate(null);

                    if (currentUser != null) {
                        NutriAppManager.NutriApp(currentUser);
                    }

                } else if (option == 2) { //Create account function
                    ProxyCreateUser create = new ProxyCreateUser();

                    currentUser = create.authenticate(null, null, null, null, null, null, null, null, null);

                    if (currentUser != null) {
                        NutriAppManager.NutriApp(currentUser);
                    }

                } else if (option == 3) { //Exit function
                    run = false;
                    System.out.println("Exit()");
                } else {
                    System.out.println("Invalid option entered, enter a number 1-3 to view data.");
                }

            } catch (InputMismatchException ime) {
                System.out.println("Invalid option entered, enter a number 1-3 to view data.");
                scanner.nextLine();
            }
        }
    }
}
