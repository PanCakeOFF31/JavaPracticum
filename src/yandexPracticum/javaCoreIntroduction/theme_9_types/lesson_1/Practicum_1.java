package yandexPracticum.javaCoreIntroduction.theme_9_types.lesson_1;

import static helpers.Helpers.*;

public class Practicum_1 {
    public static void practicum_1() {
        printSection("Practicum_1. Второй спринт начало");

//        Инициализация переменных типа класса
        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Инициализация переменных типа класса");

        VoidClass voidClass = new VoidClass();
        System.out.println(voidClass);

//      java: variable voidClass_2 might not have been initialized
//        VoidClass voidClass_2;
//        System.out.println(voidClass_2);

        printSubSectionEnding();
    }

}
     /*private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/

class VoidClass {
    String str = "Hi!";


    @Override
    public String toString() {
        return str;
    }
}

