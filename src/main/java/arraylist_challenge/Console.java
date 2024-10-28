package arraylist_challenge;

import java.util.Scanner;

public class Console {

    private boolean end = false;
    private GroceryList glist;

    public Console(GroceryList gList) {
        this.glist = gList;
    }

    public String printMenu() {
        return "Available actions:\n" +
                "0 - to shutdown\n" +
                "1 - to add item(s) to list (comma delimited list)\n" +
                "2 - to remove any items (comma delimited list)\n" +
                "Enter a number for which action you want to do:\n";
    }

    public void makeListAction(int actionNumber) {
        Scanner sc = new Scanner(System.in);
        switch (actionNumber) {
            case -1 -> printMenu();
            case 0 -> {
                setEnd(true);
                System.out.println("Program is shutting down");
            }
            case 1 -> {
                System.out.println("Now enter comma delimited list of groceries you want to add.");
                glist.addItems(sc.nextLine());
            }
            case 2 -> {
                System.out.println("Now enter comma delimited list of groceries you want to remove.");
                glist.removeItems(sc.nextLine());
            }
            default -> System.out.println("Invalid number");
        }
    }

    public int listenCommandNumber() {
        Scanner sc = new Scanner(System.in);
        try {
            int actionNumber = sc.nextInt();
            if (actionNumber >= 0 && actionNumber < 3) {
                System.out.println("You have entered option " + actionNumber);
                return actionNumber;
            } else
                System.out.println("You have entered a wrong number.");
        } catch (Exception e) {
            System.out.println("You haven't entered a number, try again.");
        }
        return -1;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
