package yandexPracticum.javaCoreIntroduction.theme_9_types.lesson_7;

import static helpers.Helpers.*;

public class Practicum_7 {
    public static void practicum_7() {
        printSection("Practicum_7. Парсим строки и не только");

//
        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Тестирую парсирующие методы");

        String text = "123.423";
        String intText = "23231";
        Integer a = Integer.parseInt(intText);
        Float b = Float.parseFloat(text);
        int c = a + 100;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println(Integer.max(a,c));
        System.out.println(a.shortValue());

        Boolean d = true;
        System.out.println();

        float e =  getFloat();



        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/

    private static Float getFloat() {
        return Float.valueOf(10.0F);
    }

}

