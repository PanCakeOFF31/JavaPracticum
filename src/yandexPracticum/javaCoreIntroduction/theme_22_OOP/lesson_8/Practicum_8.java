package yandexPracticum.javaCoreIntroduction.theme_22_OOP.lesson_8;

import java.util.ArrayList;
import java.util.List;

import static helpers.Helpers.*;

public class Practicum_8 {
    public static void practicum_8() {
        printSection("Practicum_8");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. ");

        Integer a = 10;
        a.doubleValue();
        Long b = 10L;
        b.doubleValue();

        List<Integer> list = new ArrayList<>();

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
