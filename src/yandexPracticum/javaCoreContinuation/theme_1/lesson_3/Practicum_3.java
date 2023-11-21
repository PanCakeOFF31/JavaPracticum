package yandexPracticum.javaCoreContinuation.theme_1.lesson_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static helpers.Helpers.*;

public class Practicum_3 {
    public static void practicum_3() {
        printSection("Practicum_3");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. ArrayList");

        List<Integer> list = new ArrayList<>(10) {
            {
                add(20);
                add(30);
                add(40);
            }

        };

        System.out.println("list = " + list);

        list.addAll(list);
        list.set(0, 100);
        System.out.println("list = " + list);


        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}
