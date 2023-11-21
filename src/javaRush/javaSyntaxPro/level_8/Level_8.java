package javaRush.javaSyntaxPro.level_8;

import static helpers.Helpers.*;

public class Level_8 {
    public static void level_8() {
        printSection("Level 8. Типы данных");

//
        program_1();


        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. ");

        String.valueOf(10);
        double a = 100.0/0.0;
        System.out.println(a);
        System.out.println(0.0/0.0); // NaN

        printSubSectionEnding();
    }

    /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}
