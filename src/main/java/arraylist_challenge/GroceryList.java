package arraylist_challenge;

import java.util.*;

public class GroceryList {

    private List<String> finalList= new ArrayList<>();
    private List<String> auxList = new ArrayList<>();

    private List<String> processInputToList(String input) {
        String[] sa = input.split(",");
        for (int i = 0; i < sa.length; i++) {
            sa[i] = sa[i].trim();
        }
        System.out.println("From your input ");
        System.out.println("\"" + input + "\"");
        System.out.println("was made this list:");
        List<String> list = Arrays.asList(sa);
        printList(list);

        return list;
    }

    public void addItems(String input) {
        auxList.addAll(processInputToList(input));
        System.out.println("These items will be added to the Grocery list.");
        finalList.addAll(checkItemsToAdd(auxList));
        printGroceryListAfterUpdate();
    }

    public void removeItems(String input) {
        auxList.addAll(processInputToList(input));
        System.out.println("These items will be removed from the Grocery list.");
        finalList.removeAll(checkItemsToRemove(auxList));
        printGroceryListAfterUpdate();
    }

    private List<String> checkItemsToAdd(List<String> list) {
        List<String> duplicatedItems = new ArrayList<>();
        for (String s : list) {
            if (finalList.contains(s))
                duplicatedItems.add(s);
        }
        if (duplicatedItems.isEmpty()) {
            System.out.println("All items will be added to the Grocery List.");
        } else {
            System.out.println("There are already items below on the Grocery list therefore won't be added.");
            printList(duplicatedItems);
            list.removeAll(duplicatedItems);
        }
        return list;
    }

    private List<String> checkItemsToRemove(List<String> list) {
        List<String> itemsToRemove = new ArrayList<>();
        for (String s : list) {
            if (finalList.contains(s))
                itemsToRemove.add(s);
        }
        if (itemsToRemove.isEmpty()) {
            System.out.println("No items from the input match the Grocery list to remove.");
            return list;
        } else {
            System.out.println("There are already items below on the Grocery list therefore won't be added.");
            printList(itemsToRemove);
            return itemsToRemove;
        }
    }

    private void printGroceryListAfterUpdate() {
        auxList.clear();
        System.out.println("Now the Grocery list contains:");
        finalList.sort(Comparator.naturalOrder());
        printList(finalList);
    }
    private void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
