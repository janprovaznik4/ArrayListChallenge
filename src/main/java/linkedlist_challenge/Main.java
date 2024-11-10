package linkedlist_challenge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Console cli = new Console(List.of(
                new Place("Brno", 206),
                new Place("Ostrava", 278),
                new Place("Pilsen", 90),
                new Place("Carlsbad", 127),
                new Place("Budweis", 150),
                new Place("Reichenberg", 110)));

        System.out.println("Welcome to the Distance list program");

        while (!cli.isEnd()) {
            System.out.println(cli.printMenu());
            cli.makeListAction(cli.listenCommandLetter());
        }

        System.out.println("Thank you for using the Distance List program. Have a nice day!");

    }
}