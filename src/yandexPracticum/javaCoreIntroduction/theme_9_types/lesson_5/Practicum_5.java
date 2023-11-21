package yandexPracticum.javaCoreIntroduction.theme_9_types.lesson_5;

import static helpers.Helpers.*;

public class Practicum_5 {
    public static void practicum_5() {
        printSection("Practicum_5. Приведение типов");

//      Просто проверка конвертации
        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Просто проверка конвертации");

        long a = 8_904_125_124_231L + 1000 ;
        float b = a;
        System.out.println(b);
        System.out.println(8.904125E12 - b);

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/
}
