package freePractise;

import java.util.HashMap;

class GetOrDefaultMethod {
    static void getOrDefaultMethod() {
        HashMap<String, Integer> items = new HashMap<>();

        String ballsName = "Balls";

        printItems(items, ballsName);

        putItems(items,  ballsName, 10);
        putItems(items,  ballsName, 100);
        putItems(items,  ballsName, 3);

    }

    private static void printItems(HashMap<String, Integer> items, String itemName) {
        System.out.println("Количество "+ itemName+": " + items.getOrDefault(itemName, 0));
    }

    private static void putItems(HashMap<String, Integer> items, String itemName, Integer itemCount) {
        items.put(itemName, items.getOrDefault(itemName, 0) + itemCount);
        printItems(items,itemName);
    }
}
