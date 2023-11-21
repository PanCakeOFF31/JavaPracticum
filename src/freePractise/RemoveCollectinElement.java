package freePractise;

import java.util.ArrayList;
import java.util.Iterator;

import static helpers.Helpers.*;

public class RemoveCollectinElement {
    public static void removeCollectoinELement() {
        printSection("Удаление элементов коллекции при прохождении по ней");

        ArrayList<String> words = new ArrayList<>();
        words.add("Hello world!");
        words.add("Amigo");
        words.add("Elly");
        words.add("Kerry");
        words.add("Bug");
        words.add("bug");
        words.add("Easy ug");
        words.add("Risha");

        ArrayList<String> copyWordsFirst = new ArrayList<>(words);
        ArrayList<String> copyWordsSecond = new ArrayList<>(words);
        ArrayList<String> copyWordsThird = new ArrayList<>(words);

        {
            printSubSection("for");

            removeBugWithFor(copyWordsFirst);
            copyWordsFirst.forEach(System.out::println);
            printSubSectionEnding();
        }

        {
            printSubSection("Iterator");
            removeBugWithWhile(copyWordsSecond);
            copyWordsSecond.forEach(System.out::println);
            printSubSectionEnding();
        }

        {
            printSubSection("a copy Of Collection");
            removeBugWithCopy(copyWordsThird);
            copyWordsThird.forEach(System.out::println);
            printSubSectionEnding();
        }


        printSectionEnding();
    }

    private static void removeBugWithFor(ArrayList<String> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase("bug")) {
                list.remove(i);
                --i;
            }
        }
    }

    private static void removeBugWithWhile(ArrayList<String> list) {
        //напишите тут ваш код
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (string.equalsIgnoreCase("bug")) {
                iterator.remove(); // Удаляем у итератора
            }
        }
    }

    private static void removeBugWithCopy(ArrayList<String> list) {
        //напишите тут ваш код
        var tempList = new ArrayList<>(list);
        for (String s : tempList) {
            if (s.equalsIgnoreCase("bug")) {
                list.remove(s);
            }
        }
    }
}
