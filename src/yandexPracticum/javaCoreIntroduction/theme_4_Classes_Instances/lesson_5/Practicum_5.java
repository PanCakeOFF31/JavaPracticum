package yandexPracticum.javaCoreIntroduction.theme_4_Classes_Instances.lesson_5;

import static helpers.Helpers.*;

public class Practicum_5 {
    public static void practicum_5() {
        printSection("Practicum_5");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Конструкторы");

        Hamster ninja = new Hamster("Ниндзя", 2, 350, "Черный");
        ninja.printName();

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printNewSection("");
        printSectionEnding();
    }*/
}

