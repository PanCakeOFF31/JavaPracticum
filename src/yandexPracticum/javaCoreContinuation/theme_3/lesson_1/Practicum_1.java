package yandexPracticum.javaCoreContinuation.theme_3.lesson_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

import static helpers.Helpers.*;

public class Practicum_1 {
    public static void practicum_1() {
        printSection("Practicum_1");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. removeIf()");

        Collection<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(200);
        list.add(300);

        System.out.println("list = " + list);

        Predicate<Integer> predicate = n -> {
            boolean result = n % 100 == 0;
            return result;
        };

        list.removeIf(predicate);

        System.out.println("list = " + list);

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}
