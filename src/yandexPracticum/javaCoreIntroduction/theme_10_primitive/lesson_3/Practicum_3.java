package yandexPracticum.javaCoreIntroduction.theme_10_primitive.lesson_3;

import static helpers.Helpers.*;

public class Practicum_3 {
    public static void practicum_3() {
        printSection("Practicum_3. Порядок вычислений");

//
        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. ");

        int classes = 8;
        int tasks = 6;
        int coffeeCups = 3;

        int variables = coffeeCups - classes * tasks + tasks / coffeeCups + (classes + coffeeCups) * tasks;
        System.out.println(variables);

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printNewSection("");
        printSectionEnding();
    }*/
}
