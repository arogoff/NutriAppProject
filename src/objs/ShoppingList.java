package src.objs;

//imports for file manipulation
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ShoppingList {
    public static void viewShoppingList() { //Function to read shopping list, create shopping list, and modify shopping list
        try { //Create the file
            File shop = new File("shoppingList.txt");
            if (shop.createNewFile()) { //If the file does not exist yet
                try { //Write to the shopping list
                    FileWriter myWriter = new FileWriter("shoppingList.txt");
                    Scanner shoppingListScanner = new Scanner(System.in);
                    System.out.println("Write your shopping list here, press enter when you're done: ");
                    if (ITEM.stock() < 3) { //Adds to shopping list if any ingredient in their house is low/out of stock
                        System.out.println("" + ITEM.stock() + "\n");
                    }
                    else { //None of the ingredients the user has are low/out of stock
                        System.out.println("All the ingredients at your house are in stock and not low in stock!");
                    }
                    String shoppingList = shoppingListScanner.nextLine(); //User input is the shopping list
                    myWriter.write(ITEM.stock() < 3);
                    myWriter.write(shoppingList); //Write user input to file
                    myWriter.close();
                    System.out.println("Shopping list updated with: " + shoppingList);
                }
                catch (IOException e) { //In case of an error
                    System.out.println("An error occurred, please try writing to the file again.");
                    e.printStackTrace();
                }
            }
            else { //File already exists
                try { //Read the file
                    File readShoppingList = new File("shoppingList.txt");
                    Scanner shoppingListReader = new Scanner(readShoppingList);
                    System.out.println("Your shopping list:");
                    while (shoppingListReader.hasNextLine()) { //Reading lines of the file
                        String list = shoppingListReader.nextLine();
                        System.out.println(list); //Prints out shopping list
                    }
                    shoppingListReader.close();

                    Boolean shopList = true; //boolean statement for modify the list loop
                    while (shopList == true) {
                        System.out.println("Would you like to modify your shopping list? [Y/N]");
                        Scanner modifyShoppingList = new Scanner(System.in);

                        String optionModifyShoppingList = modifyShoppingList.nextLine(); //user input is the option of the user to modify their shopping list

                        if (optionModifyShoppingList.equals("Y") || optionModifyShoppingList.equals("y")) { //If user enters Y/y
                            File deleteShoppingList = new File("shoppingList.txt");
                            if (deleteShoppingList.delete()) { //Deletes shopping list
                                viewShoppingList(); //user will not be prompted to create their shopping list
                            }
                            else {
                                System.out.println("Could not execute rewrite of file, please try again."); //Error occurred
                            }
                            shopList = false; //Ends while loop
                        }
                        else if (optionModifyShoppingList.equals("N") || optionModifyShoppingList.equals("n")) { //User does not wish to modify their shopping list
                            shopList = false; //Ends while loop
                        }
                        else { //User entered input that is not accepted by system, "Y/N"
                            System.out.println("Invalid option selected, select Y/N.");
                        }
                    }
                }
                catch (FileNotFoundException e) { //Couldn't read the file
                    System.out.println("An unknown error occurred, please try again later.");
                    e.printStackTrace();
                }

            }
        }
        catch (IOException e) { //Couldn't create file
            System.out.println("Error, please try again and check file name.");
            e.printStackTrace();
        }
    }
}
