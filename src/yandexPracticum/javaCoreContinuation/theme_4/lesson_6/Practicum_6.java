package yandexPracticum.javaCoreContinuation.theme_4.lesson_6;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import static helpers.Helpers.*;

public class Practicum_6 {


    public static void practicum_6() {
        printSection("Practicum_6. Set");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Comparator in set");

        Comparator<Test> comparator = new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return 0;
            }
        };

        Set<Test> set_1 = new TreeSet<>(comparator);
        Set<Test> set_2 = new TreeSet<>(new SimpleComparator());

//        LocalDate ld = new LocalDate.of();

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}

class SimpleComparator implements Comparator<Test> {

    @Override
    public int compare(Test o1, Test o2) {
        return 0;
    }
}

class Test {
    int a;
}
