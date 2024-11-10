package linkedlist_challenge;
import java.util.*;

public class Console {

    private boolean end = false;
    private List<Place> cityList = new LinkedList<>();
    private ListIterator<Place> iterator;
    char[] allowedInputChars = {'B', 'F', 'L', 'M', 'Q'};

    public Console(List<Place> cityList) {
        this.cityList.addAll(cityList);
        this.iterator = this.cityList.listIterator();
    }

    public String printMenu() {
        return "Available actions (type the first letter):\n" +
                "(F)orward\n" +
                "(B)ackward\n" +
                "(L)ist Places\n" +
                "(M)enu\n" +
                "(Q)uit\n" +
                "Enter a letter for which action you want to do:\n";
    }

    public void makeListAction(char actionLetter) {
        switch (actionLetter) {
            case 'M' -> printMenu();
            case 'Q' -> {
                setEnd(true);
                System.out.println("Program is shutting down");
            }
            case 'F' -> {
                if (iterator.hasNext()) {
                    Place nextCity = iterator.next();
                    System.out.println("You are leaving " + nextCity.name() + " which is " + nextCity.distance()
                            + "kilometers from Prague the capital.");
                } else
                    System.out.println("There isn't any next city in the itinerary. You can only go backwards.");
            }
            case 'B' -> {
                if (iterator.hasPrevious()) {
                    Place nextCity = iterator.previous();
                    System.out.println("You are returning to " + nextCity.name() + " which is " + nextCity.distance()
                            + "kilometers from Prague the capital.");
                } else
                    System.out.println("There isn't any previous city in the itinerary. You can only go forwards.");
            }
            case 'L' -> {
                System.out.println("The itinerary contains these cities with distance from Prague:");
                cityList.forEach(c -> System.out.println(c.name() + " " + c.distance() + "kms"));
            }
            default -> System.out.println("Invalid character.");
        }
    }

    public char listenCommandLetter() {
        Scanner sc = new Scanner(System.in);
        try {
            String inputText = sc.nextLine();
            if(inputText.length() != 1)
                throw new IllegalArgumentException("You haven't entered one character, try again.");
            char actionLetter = inputText.toUpperCase().charAt(0);
            if (Arrays.binarySearch(allowedInputChars, actionLetter) >= 0) {
                System.out.println("You have entered option '" + actionLetter + "'");
                return actionLetter;
            } else
                System.out.println("You have entered a wrong character.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            //System.out.println("You haven't entered a number, try again.");
        }
        return 'Z';
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
