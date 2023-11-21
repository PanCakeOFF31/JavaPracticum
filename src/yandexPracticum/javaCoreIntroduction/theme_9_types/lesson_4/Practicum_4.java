package yandexPracticum.javaCoreIntroduction.theme_9_types.lesson_4;

import static helpers.Helpers.*;

public class Practicum_4 {
    public static void practicum_4() {
        printSection("Practicum_4. Значения по умолчанию");

//        Значения по умолчанию
        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Значения по умолчанию через пустые поля");

        Default default_1 = new Default();
        default_1.printDefaultValues();

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/

}

class Default {
    private int a;
    private long b;
    private float c;
    private double d;
    private boolean e;
    private char f;
    private String g;

    void printDefaultValues() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        System.out.println("g = " + g);
    }
}
