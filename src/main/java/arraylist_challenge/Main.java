package arraylist_challenge;

import arraylist_challenge.Console;
import arraylist_challenge.GroceryList;

public class Main {
    public static void main(String[] args) {
        Console cli = new Console(new GroceryList());

        System.out.println("Welcome to the Grocery list program");

        while (!cli.isEnd()) {
            System.out.println(cli.printMenu());
            cli.makeListAction(cli.listenCommandNumber());
        }

        System.out.println("Thank you for using the Grocery List program. Have a nice day!");

    }
}